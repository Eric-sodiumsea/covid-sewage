package com.sztu.covid19.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PlaceResult {

    private Integer id;
    private String placeName;
    private List<VirusResult> monthList = new ArrayList<>();
}
