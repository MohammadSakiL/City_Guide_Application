package com.example.cityguide.HelperClass.HomeAdapter;

import android.graphics.drawable.Drawable;

public class CategoryHelperClass {
    int image;
    Drawable gradient;
    String title;

    public CategoryHelperClass(Drawable gradient, int image, String title) {
        this.gradient = gradient;
        this.image = image;
        this.title = title;
    }

    public Drawable getGradient() {
        return gradient;
    }

    public void setGradient(Drawable gradient) {
        this.gradient = gradient;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
