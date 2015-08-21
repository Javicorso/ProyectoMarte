/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unbosque.swii.marte.util;

/**
 *
 * @author Huber
 */
public enum OrientacionEnum {

    NORTH('N'),
    SOUTH('S'),
    EAST('E'),
    WEST('0');

    private char code;

    private OrientacionEnum(char code) {
        this.code = code;
    }

    public char getCode() {
        return code;
    }

}
