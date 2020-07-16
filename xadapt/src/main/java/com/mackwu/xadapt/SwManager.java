package com.mackwu.xadapt;

public class SwManager {

    private static SwManager instance = null;

    private SwManager() {
    }

    public static SwManager getInstance() {
        if (instance == null) {
            synchronized (SwManager.class) {
                if (instance == null) {
                    instance = new SwManager();
                }
            }
        }
        return instance;
    }


    /**
     * 设计图尺寸=1080x1920
     */
    public void makeDesignWidth1080(){
        SwMaker swMaker = new SwMaker.Builder()
                .designWidth(1080)
                .moduleName("app")
//                .swValues(new int[]{540})
                .build();
        swMaker.makeAllDimens();
    }

}
