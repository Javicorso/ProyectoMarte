/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unbosque.swii.marte.util;

import static java.awt.Color.white;

/**
 *
 * @author Huber
 */
public enum ColorEnum {

    WHITE(0),
    RED(1),
    YELLOW(2),
    BLUE(3),
    PINK(4),
    ORANGE(5),
    GREEN(6);

    private int code;

    private ColorEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
