package com.recipehub;

import android.content.Context;
import android.widget.TextView;
import androidx.annotation.NonNull;

// PUBLIC_INTERFACE
public class AuthenticationView extends TextView {
    public AuthenticationView(@NonNull Context context) {
        super(context);
        setText("Authentication (placeholder)");
    }
}
