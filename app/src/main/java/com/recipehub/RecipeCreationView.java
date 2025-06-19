package com.recipehub;

import android.content.Context;
import android.widget.TextView;
import androidx.annotation.NonNull;

// PUBLIC_INTERFACE
public class RecipeCreationView extends TextView {
    public RecipeCreationView(@NonNull Context context) {
        super(context);
        setText("Recipe Creation (placeholder)");
    }
}
