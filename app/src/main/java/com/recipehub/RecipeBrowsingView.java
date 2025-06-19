package com.recipehub;

import android.content.Context;
import android.widget.TextView;
import androidx.annotation.NonNull;

// PUBLIC_INTERFACE
public class RecipeBrowsingView extends TextView {
    public RecipeBrowsingView(@NonNull Context context) {
        super(context);
        setText("Recipe Browsing (placeholder)");
    }
}
