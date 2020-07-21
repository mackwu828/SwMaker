package com.mackwu.app;

import com.mackwu.xadapt.SwMaker;

public class Test {

    public static void main(String[] args) {
        SwMaker swMaker = new SwMaker.Builder()
                .designWidth(1080)
                .build();
        swMaker.makeAllDimens();

//        SwMaker swMaker = new SwMaker.Builder()
//                .designWidth(1080)
//                .moduleName("app")
//                .swValues(new int[]{360, 540, 720, 1080})
//                .dpMin(-50)
//                .dpMax(1920)
//                .spMax(120)
//                .prefix("")
//                .build();
//        swMaker.makeAllDimens();
    }
}
