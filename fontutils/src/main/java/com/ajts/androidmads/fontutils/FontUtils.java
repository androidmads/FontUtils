package com.ajts.androidmads.fontutils;

import android.content.Context;
import android.graphics.Typeface;
import android.support.design.widget.NavigationView;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Mushtaq on 17-03-2018.
 */

public class FontUtils {

    private Context context;

    public FontUtils(Context _context) {
        context = _context;
    }

    public void applyFontToToolbar(Toolbar toolbar, Typeface typeface) {
        for (int i = 0; i < toolbar.getChildCount(); i++) {
            View view = toolbar.getChildAt(i);
            if (view instanceof TextView) {
                TextView tv = (TextView) view;
                tv.setTypeface(typeface);
                break;
            }
        }
    }

    public void applyFontToMenu(Menu menu, Typeface typeface) {
        for (int i = 0; i < menu.size(); i++) {
            MenuItem menuItem = menu.getItem(i);
            SubMenu subMenu = menuItem.getSubMenu();
            if (subMenu != null && subMenu.size() > 0) {
                for (int j = 0; j < subMenu.size(); j++) {
                    MenuItem subMenuItem = subMenu.getItem(j);
                    applyFontToMenuItem(subMenuItem, typeface);
                }
            }
            applyFontToMenuItem(menuItem, typeface);
        }
    }

    public void applyFontToSubMenu(SubMenu menu, Typeface typeface) {
        for (int i = 0; i < menu.size(); i++) {
            MenuItem menuItem = menu.getItem(i);
            SubMenu subMenu = menuItem.getSubMenu();
            if (subMenu != null && subMenu.size() > 0) {
                for (int j = 0; j < subMenu.size(); j++) {
                    MenuItem subMenuItem = subMenu.getItem(j);
                    applyFontToMenuItem(subMenuItem, typeface);
                }
            }
            applyFontToMenuItem(menuItem, typeface);
        }
    }

    private void applyFontToMenuItem(MenuItem mi, Typeface typeface) {
        SpannableString mNewTitle = new SpannableString(mi.getTitle());
        mNewTitle.setSpan(new MenuItemTypefaceSpan("", typeface),
                0, mNewTitle.length(),
                Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        mi.setTitle(mNewTitle);
    }

    public void applyFontToNavigationView(NavigationView navigationView, Typeface typeface) {
        applyFontToMenu(navigationView.getMenu(), typeface);
    }

    public void applyFontToView(View view, Typeface typeface) {
        if (view instanceof TextView) {
            TextView tv = (TextView) view;
            tv.setTypeface(typeface);
        }
    }

}
