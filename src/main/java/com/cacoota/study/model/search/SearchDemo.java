package com.cacoota.study.model.search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

@Document(indexName = "demo", type = "doc")
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class SearchDemo implements Serializable {

    @Id
    private Long id;

    @Field(type = FieldType.Keyword)
    private String name;

    @Field(index = false, type = FieldType.Keyword)
    private String image;

}
