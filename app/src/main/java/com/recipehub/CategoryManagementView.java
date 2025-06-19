package com.recipehub;

import android.content.Context;
import android.widget.TextView;
import androidx.annotation.NonNull;

// PUBLIC_INTERFACE
public class CategoryManagementView extends TextView {
    public CategoryManagementView(@NonNull Context context) {
        super(context);
        setText("Category Management (placeholder)");
    }
}
