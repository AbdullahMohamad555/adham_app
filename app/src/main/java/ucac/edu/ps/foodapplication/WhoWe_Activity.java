package ucac.edu.ps.foodapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class WhoWe_Activity extends AppCompatActivity {

    TabLayout tab_gaza;
    ViewPager viewPager_gaza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_who_we);

        tab_gaza = findViewById(R.id.tab_whoWe);
        viewPager_gaza = findViewById(R.id.viewPager_whoWe);

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());

        Category category1 = new Category(0, "غزة الخير");
        adapter.AddTabs(new MyTab(category1, gaza_fragment.newInstance(1, "غزة الخير")));
        //
        Category category2 = new Category(1, "المشاريع/البرامج");
        adapter.AddTabs(new MyTab(category2, project_fragment.newInstance(2, "المشاريع/البرامج")));

        viewPager_gaza.setAdapter(adapter);
        tab_gaza.setupWithViewPager(viewPager_gaza);

        tab_gaza.getTabAt(0).setIcon(R.drawable.projects);
        tab_gaza.getTabAt(1).setIcon(R.drawable.hand);


    }
}