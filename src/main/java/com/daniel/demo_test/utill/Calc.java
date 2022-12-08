package com.daniel.demo_test.utill;

import com.daniel.demo_test.beans.Grade;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by danielR on 08/12/2022
 */
public class Calc {
    public static double avgScoreCalc(List<Grade> grades) {
//        int sum = 0;
//        for (int i = 0; i < grades.size(); i++) {
//            sum += grades.get(i).getScore();
//        }

        List<Integer>scores=new ArrayList<>();
        for (Grade g:grades) {
            scores.add(g.getScore());
        }
        return scores.stream().mapToInt((a) -> a).average().stream().sum();
    }
}
