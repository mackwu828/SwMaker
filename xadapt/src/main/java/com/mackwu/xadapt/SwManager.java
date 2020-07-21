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
     * 设计图尺寸: 1920x1080
     */
    public void makeDesignWidth1080() {
        SwMaker swMaker = new SwMaker.Builder()
                .designWidth(1080)
                .build();
        swMaker.makeAllDimens();
    }

    /**
     * 设计图尺寸: 1920x1080
     * 前缀：weather
     */
    public void makeDesignWidth1080WeatherPrefix() {
        SwMaker swMaker = new SwMaker.Builder()
                .designWidth(1080)
                .prefix("weather")
                .build();
        swMaker.makeAllDimens();
    }

    /**
     * 设计图尺寸: 960x540
     */
    public void makeDesignWidth540() {
        SwMaker swMaker = new SwMaker.Builder()
                .designWidth(540)
                .build();
        swMaker.makeAllDimens();
    }
}
