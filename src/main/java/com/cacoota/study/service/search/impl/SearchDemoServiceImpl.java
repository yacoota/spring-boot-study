package com.cacoota.study.service.search.impl;


import com.cacoota.study.mapper.search.SearchDemoRepository;
import com.cacoota.study.model.search.SearchDemo;
import com.cacoota.study.service.search.SearchDemoService;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

@Service
public class SearchDemoServiceImpl implements SearchDemoService {

    @Autowired
    private ElasticsearchTemplate template;

    @Autowired
    private SearchDemoRepository repository;

    @Override
    public String insert(SearchDemo demo) {
        IndexQuery index = new IndexQueryBuilder().withObject(demo).build();
        return template.index(index);
    }

    @Override
    public SearchDemo save(SearchDemo demo) {
        return repository.save(demo);
    }

    @Override
    public Iterable<SearchDemo> find(String name) {
        return repository.findAll(Sort.by(Sort.Direction.DESC, name));
    }

    @Override
    public Iterable<SearchDemo> matchSearch(MatchQueryBuilder builder) {
        return repository.search(builder);
    }

    @Override
    public Page<SearchDemo> nativeSearch(NativeSearchQueryBuilder builder) {
        return repository.search(builder.build());
    }
}
