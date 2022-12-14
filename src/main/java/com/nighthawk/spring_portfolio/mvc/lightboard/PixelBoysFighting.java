package com.nighthawk.spring_portfolio.mvc.lightboard;

import java.util.ArrayList;
import java.util.List;

public class PixelBoysFighting extends LightBoard {
    
    private int rowMax;
    private int colMax;

    public PixelBoysFighting(int row, int col) {
        super(row, col);
        this.rowMax = lights.length;
        this.colMax = lights[0].length;
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
        if (color.equals("green")) {
            return new Light((short) 0, (short) 255, (short) 0);
        } else if (color.equals("red")) {
            return new Light((short) 255, (short) 0, (short) 0);
        } else {
            return new Light((short) 0, (short) 0, (short) 255);
        }
    }
    
    private static String findMax(short red, short green, short blue) {

        if (red > blue && red > green) {    
            return "red";
        } else if (green > red && green > blue) {
            return "green";
        } else if (blue > green && blue > red) {
            return "blue";
        } else {
            double rand = Math.random() * 3;

            // all the values are the same
            if (red == blue && red == green) {
                if (rand <= 1) {
                    return "red";
                } else if (rand > 2) {
                    return "green";
                } else {
                    return "blue";
                }
            }

            // red and blue are the maxes
            if (red == blue) {
                if (rand < 1.5) {
                    return "red";
                } else {
                    return "blue";
                }
            }

            // red and green are the maxes
            if (red == green) {
                if (rand < 1.5) {
                    return "red";
                } else {
                    return "green";
                }
            }

            // green and blue are the maxes
            if (blue == green) {
                if (rand < 1.5) {
                    return "green";
                } else {
                    return "blue";
                }
            }

            return "error";
        }
    }

    private List<Light> lightListAdd( int row, int col) {
        List<Light> lightList = new ArrayList<Light>();

        if (row > 0) {
            lightList.add(lights[row-1][col]);    
        } if (row < rowMax - 1) {
            lightList.add(lights[row+1][col]);
        } if (col > 0) {
            lightList.add(lights[row][col-1]);
        } if (col < colMax - 1) {
            lightList.add(lights[row][col+1]);
        }
        lightList.add(lights[row][col]);

        return lightList;
    }

    private void iterate() {
        
        Light[][] newLightBoard = new Light[rowMax][colMax];

        for (int row = 0; row < rowMax; row++) {
            for (int col = 0; col < colMax; col++) {

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

        PixelBoysFighting obj = new PixelBoysFighting(50, 50);

        obj.toFile("src/main/resources/static/images/lightboardImgs/iteration0.png");

        for (int i = 1; i < 10; i++) {
            obj.iterate();
            obj.toFile("src/main/resources/static/images/lightboardImgs/iteration" + i + ".png");
        }
    }
}
