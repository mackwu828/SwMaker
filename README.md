


## 一、添加依赖


## 二、用法
2.1 自定义设计图尺寸。如1920x1080
```
        SwMaker swMaker = new SwMaker.Builder()
                .designWidth(1080)
                .build();
        swMaker.makeAllDimens();
```

2.2 自定义最小宽度。默认根据dpi换算。
```
        SwMaker swMaker = new SwMaker.Builder()
                .designWidth(1080)
                .swValues(new int[]{540, 720, 1080})
                .build();
        swMaker.makeAllDimens();
```

2.3 自定义dp、sp最小和最大长度
```
        SwMaker swMaker = new SwMaker.Builder()
                .designWidth(1080)
                .dpMin(-50)
                .dpMax(1920)
                .spMax(120)
                .build();
        swMaker.makeAllDimens();
```

2.4 自定义dimen前缀
```
        SwMaker swMaker = new SwMaker.Builder()
                .designWidth(1080)
                .prefix("weather")
                .build();
        swMaker.makeAllDimens();
```


完整用法：
```
        SwMaker swMaker = new SwMaker.Builder()
                .designWidth(1080)
                .moduleName("app")
                .swValues(new int[]{360, 540, 720, 1080})
                .dpMin(-50)
                .dpMax(1920)
                .spMax(120)
                .prefix("")
                .build();
        swMaker.makeAllDimens();
```