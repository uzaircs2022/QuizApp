package com.example.quiz.utils;

import android.graphics.Color;

import com.example.quiz.R;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class IconPicker {
    private static IconPicker Icon_picker = null;

    public static IconPicker getInstance() {
        if (Icon_picker == null) {
            Icon_picker = new IconPicker();
        }
        return Icon_picker;
    }

    List<Integer> Icons = Arrays.asList(R.drawable.ic__icon_1,R.drawable.ic__icon_2,R.drawable.ic__icon_3,R.drawable.ic__icon_4,R.drawable.ic__icon_5,R.drawable.ic__icon_6,R.drawable.ic__icon_7);
    int currentIcon = 0;

    public int getIcon() {
        currentIcon = (currentIcon + 1) % Icons.size();
        return Icons.get(currentIcon);
    }
}

