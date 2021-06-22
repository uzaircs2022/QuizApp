package com.example.quiz.utils;

import android.graphics.Color;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class ColorPicker {
    private static ColorPicker color_picker = null;

    public static ColorPicker getInstance() {
        if (color_picker == null) {
            color_picker = new ColorPicker();
        }
        return color_picker;
    }

    List<String> colors = Arrays.asList("red", "gray", "cyan", "yellow", "black","lightgray","darkgray");
    int currentColorIndex = 0;

    public String getColor() {
        currentColorIndex = (currentColorIndex + 1) % colors.size();
        return colors.get(currentColorIndex);
    }
}
