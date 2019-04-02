package com.eirandanan.simon;

import android.graphics.drawable.ColorDrawable;
import android.view.View;

public class Utils {

    public static void xorMyColor(View v){
        ColorDrawable colorDrawable = (ColorDrawable) v.getBackground();
        int color = colorDrawable.getColor();
        v.setBackgroundColor(color^0X22222222);
    }
}
