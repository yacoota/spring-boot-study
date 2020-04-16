package com.cacoota.study.mapper.search;

import com.cacoota.study.model.search.SearchDemo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface SearchDemoRepository extends ElasticsearchRepository<SearchDemo, Long> {

}
