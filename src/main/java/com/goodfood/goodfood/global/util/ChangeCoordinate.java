package com.goodfood.goodfood.global.util;

import org.osgeo.proj4j.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class ChangeCoordinate {

    public void change(double x, double y){

        // 좌표 변환을 위한 CoordinateTransform 객체 생성
        CoordinateTransformFactory ctFactory = new CoordinateTransformFactory();
        CRSFactory crsFactory = new CRSFactory();
        CoordinateReferenceSystem epsg2097 = crsFactory.createFromName("EPSG:2097");
        CoordinateReferenceSystem wgs84 = crsFactory.createFromName("EPSG:4326");
        CoordinateTransform transform = ctFactory.createTransform(epsg2097, wgs84);

        // 좌표 변환
        ProjCoordinate srcCoord = new ProjCoordinate(x, y);
        ProjCoordinate targetCoord = new ProjCoordinate();
        transform.transform(srcCoord, targetCoord);

        // WGS84 좌표 출력
        System.out.println("WGS84 X: " + targetCoord.x);
        System.out.println("WGS84 Y: " + targetCoord.y);

    }

}
