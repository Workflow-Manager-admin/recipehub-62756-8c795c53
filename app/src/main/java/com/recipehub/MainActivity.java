package com.recipehub;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.content.res.ColorStateList;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private FrameLayout mainContent;

    // Theme colors as constants
    public static final int COLOR_PRIMARY = 0xFF4CAF50;
    public static final int COLOR_SECONDARY = 0xFFFFC107;
    public static final int COLOR_ACCENT = 0xFFFF5722;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Force light theme
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        // Set up layout programmatically for a modern, stylized look
        drawerLayout = new DrawerLayout(this);
        drawerLayout.setId(View.generateViewId());

        // Sidebar navigation
        navigationView = new NavigationView(this);
        DrawerLayout.LayoutParams navParams = new DrawerLayout.LayoutParams(
                DrawerLayout.LayoutParams.WRAP_CONTENT,
                DrawerLayout.LayoutParams.MATCH_PARENT
        );
        navParams.gravity = GravityCompat.START;
        navigationView.setLayoutParams(navParams);

        // Setup menu for navigationView
        navigationView.inflateMenu(R.menu.drawer_menu);

        // Set theme colors for navigation drawer
        navigationView.setBackgroundColor(COLOR_PRIMARY);
        navigationView.setItemTextColor(ColorStateList.valueOf(COLOR_SECONDARY));
        navigationView.setItemIconTintList(ColorStateList.valueOf(COLOR_ACCENT));

        // Main content area
        mainContent = new FrameLayout(this);
        mainContent.setId(View.generateViewId());
        DrawerLayout.LayoutParams mainParams = new DrawerLayout.LayoutParams(
                DrawerLayout.LayoutParams.MATCH_PARENT,
                DrawerLayout.LayoutParams.MATCH_PARENT
        );
        mainContent.setLayoutParams(mainParams);

        drawerLayout.addView(mainContent);
        drawerLayout.addView(navigationView);

        setContentView(drawerLayout);

        setupNavigation();
        // Load initial fragment or content
        showRecipeBrowsing();
    }

    // PUBLIC_INTERFACE
    private void setupNavigation() {
        /** Sets up drawer menu for app navigation. */
        navigationView.setNavigationItemSelectedListener(
            new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    drawerLayout.closeDrawers();
                    switch (item.getItemId()) {
                        case R.id.nav_browse:
                            showRecipeBrowsing();
                            return true;
                        case R.id.nav_create:
                            showRecipeCreation();
                            return true;
                        case R.id.nav_auth:
                            showAuthentication();
                            return true;
                        case R.id.nav_categories:
                            showCategoryManagement();
                            return true;
                        // Add user management as needed
                        default:
                            return false;
                    }
                }
            }
        );
    }

    // PUBLIC_INTERFACE
    private void showRecipeBrowsing() {
        /** Loads/binds the Recipe Browsing UI */
        // TODO: Replace with actual fragment or view.
        mainContent.removeAllViews();
        mainContent.addView(new RecipeBrowsingView(this));
    }

    // PUBLIC_INTERFACE
    private void showRecipeCreation() {
        /** Loads the Recipe Creation UI */
        mainContent.removeAllViews();
        mainContent.addView(new RecipeCreationView(this));
    }

    // PUBLIC_INTERFACE
    private void showAuthentication() {
        /** Loads Authentication/Login/Register UI */
        mainContent.removeAllViews();
        mainContent.addView(new AuthenticationView(this));
    }

    // PUBLIC_INTERFACE
    private void showCategoryManagement() {
        /** Loads Category Management UI */
        mainContent.removeAllViews();
        mainContent.addView(new CategoryManagementView(this));
    }
}
