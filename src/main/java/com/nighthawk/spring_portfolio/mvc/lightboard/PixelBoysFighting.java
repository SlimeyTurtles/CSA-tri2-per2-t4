package com.nighthawk.spring_portfolio.mvc.lightboard;

import java.util.ArrayList;
import java.util.List;

public class PixelBoysFighting extends LightBoard {
    
    private int rowMax;
    private int colMax;

    public PixelBoysFighting(int row, int col) {
        super(row, col);
        this.rowMax = lights.length-1;
        this.colMax = lights[0].length-1;
        roundLightBoard();
    }

    private void roundLightBoard() {
        
        Light[][] roundedLightBoard = new Light[rowMax][colMax];

        for (int row = 0; row < rowMax; row++) {
            for (int col = 0; col < colMax; col++) {
                
                Light unroundedLight = lights[row][col];
                String color = findMax(unroundedLight.getRed(), unroundedLight.getGreen(), unroundedLight.getBlue()); 
                roundedLightBoard[row][col] = createLight(color);

            }
        }

        lights = roundedLightBoard;
    }

    private static Light createLight(String color) {
        if (color.equals("red")) {
            return new Light((short) 255, (short) 0, (short) 0);
        } else if (color.equals("green")) {
            return new Light((short) 0, (short) 255, (short) 0);
        } else {
            return new Light((short) 0, (short) 0, (short) 255);
        }
    }
    
    private static String findMax(short red, short green, short blue) {

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

    private List<Light> lightListAdd( int row, int col) {
        List<Light> lightList = new ArrayList<Light>();

        System.out.println("col" + col);
        System.out.println("max" + colMax);

        if (row != 0) {
            lightList.add(lights[row-1][col]);    
        } if (row != rowMax) {
                lightList.add(lights[row+1][col]);
        } if (col != 0) {
            lightList.add(lights[row][col-1]);
        } if (col != colMax) {
            lightList.add(lights[row][col+1]);
        }
        lightList.add(lights[row][col]);

        return lightList;
    }

    private void iterate() {
        
        Light[][] newLightBoard = new Light[rowMax][colMax];

        for (int row = 0; row <= rowMax; row++) {
            for (int col = 0; col <= colMax; col++) {

                System.out.println("row: " + row);
                System.out.println("col: " + col);

                short r = 0;
                short g = 0;
                short b = 0;

                List<Light> lightList = lightListAdd(row, col);

                for (Light light : lightList) {
                    
                    String color = findMax(light.getRed(), light.getGreen(), light.getBlue());

                    if (color.equals("red")) {
                        r++;
                    } else if (color.equals("green")) {
                        g++;
                    } else if (color.equals("blue")) {
                        b++;
                    } else {
                        System.out.println("how did this happen");
                    }
                }

                String newColor = findMax(r, g, b);

                newLightBoard[row][col] = createLight(newColor);
            }
        }

        this.lights = newLightBoard;
    }

    public static void main(String[] args) {
        PixelBoysFighting obj = new PixelBoysFighting(10, 10);
        obj.toFile("src/main/resources/static/images/lightboardImgs/iteration1.png");
        obj.iterate();
        obj.toFile("src/main/resources/static/images/lightboardImgs/iteration2.png");
        obj.iterate();
        obj.toFile("src/main/resources/static/images/lightboardImgs/iteration3.png");
        obj.iterate();
        obj.toFile("src/main/resources/static/images/lightboardImgs/iteration4.png");
        obj.iterate();
        obj.toFile("src/main/resources/static/images/lightboardImgs/iteration5.png");
    }
}
