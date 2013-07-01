package com.gmail.leonidandand.sokoban;

import android.app.ActionBar;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.Random;

public class EditorActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        prepareTable();
    }

    private void prepareTable() {
        final int ROWS = getResources().getInteger(R.integer.rows);
        final int COLUMNS = getResources().getInteger(R.integer.columns);
        LinearLayout editorVerticalLayout = (LinearLayout) findViewById(R.id.editorVerticalLayout);
        for (int row = 0; row < ROWS; ++row) {
            LinearLayout layout = prepareRow(COLUMNS);
            editorVerticalLayout.addView(layout);
        }
    }

    private LinearLayout prepareRow(int columns) {
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.HORIZONTAL);
        for (int col = 0; col < columns; ++col) {
            layout.addView(prepareTableElement());
        }
        addParams(layout);
        layout.setBackgroundColor(new Random().nextBoolean() ? Color.BLACK : Color.WHITE);
        return layout;
    }

    private View prepareTableElement() {
        ImageView tableElement = new ImageView(this);
        tableElement.setImageDrawable(getResources().getDrawable(R.drawable.img));
        addParams(tableElement);
        tableElement.setScaleType(ImageView.ScaleType.FIT_XY);
        return tableElement;
    }

    private void addParams(View view) {
        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT,
                1.0f);
        view.setLayoutParams(param);
    }

}
