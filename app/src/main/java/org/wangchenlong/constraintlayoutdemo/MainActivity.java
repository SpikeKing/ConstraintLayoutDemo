package org.wangchenlong.constraintlayoutdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    // 项名称
    private static final String[] LIST_ITEMS = {
            "Base",
            "Bias",
            "Guide Line",
            "Measure",
            "Aspect Ratio"
    };

    // 项布局Id
    private static final int[] LAYOUT_IDS = {
            R.layout.layout_base,
            R.layout.layout_bias,
            R.layout.layout_guide_line,
            R.layout.layout_measure,
            R.layout.layout_aspect_ratio
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = (ListView) findViewById(R.id.activity_main);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, LIST_ITEMS);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // 复用显示布局
                Intent intent = new Intent(MainActivity.this, LayoutDisplayActivity.class);
                intent.putExtra(Intent.EXTRA_TITLE, LIST_ITEMS[i]); // 标题
                intent.putExtra(LayoutDisplayActivity.EXTRA_LAYOUT_ID, LAYOUT_IDS[i]); // 布局Id
                startActivity(intent);
            }
        });
    }
}
