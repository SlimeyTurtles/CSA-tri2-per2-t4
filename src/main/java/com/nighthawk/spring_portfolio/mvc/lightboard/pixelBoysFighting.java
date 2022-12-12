package com.nighthawk.spring_portfolio.mvc.lightboard;

import java.util.ArrayList;
import java.util.List;

public class pixelBoysFighting {
    
    private short red;
    private short green;
    private short blue;

    public pixelBoysFighting() {
        this.red = 0;
        this.green = 0;
        this.blue = 0;
    }

    private String round(Light light) {
        short red = light.getRed();
        short green = light.getGreen();
        short blue = light.getBlue();
        
        
        if (red > blue) {
            if (red > green) {
                return "red";
            } else if (green > red) {
                return "green";
            } else {
                if (Math.random() < 0.5) {
                    return "red";
                } else {
                    return "green";
                }
            }
        } else if (blue > red) {
            if (blue > green) {
                return "blue";
            } if (green > blue) {
                return "green";
            } else {
                if (Math.random() < 0.5) {
                    return "blue";
                } else {
                    return "green";
                }
            }
        } else {
            if (Math.random() < 0.5) {
                return "red";
            } else {
                return "blue";
            }
        }
    }
    
    public static Light[][] iterate(Light[][] lightBoard) {
        
        int rowMax = lightBoard.length;
        int colMax = lightBoard[0].length;
        Light[][] newLightBoard = new Light[rowMax][colMax];

        for (int row = 0; row <= rowMax; row++) {
            for (int col = 0; col <= colMax; col++) {

                int r = 0;
                int g = 0;
                int b = 0;

                List<Light> lightList = new ArrayList<Light>();

                if (row != 0) {
                    lightList.append()    
                } if (row != rowMax) {

                } if (col != 0) {

                } if (col != colMax) {

                }
                if lightBoard[row][col]

            }
        }

        return newLightBoard
    }
}
