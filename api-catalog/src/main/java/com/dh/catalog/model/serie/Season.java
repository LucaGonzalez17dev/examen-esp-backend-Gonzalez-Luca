package com.dh.catalog.model.serie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Season {



    private Integer seasonNumber;
    private List<Chapter> chapters = new ArrayList<>();


}
