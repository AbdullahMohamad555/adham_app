package ucac.edu.ps.foodapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;

public class TabedActivity extends AppCompatActivity {
    private TabLayout tab;
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabed);

        tab = findViewById(R.id.tabedLayout);
        pager = findViewById(R.id.viewPager);

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());

        Category category1 = new Category(0, "الرئيسية");
        adapter.AddTabs(new MyTab(category1, HomeFragment.newInstance(1, "الرئيسية")));
        //
        Category category2 = new Category(1, "حملات التبرع");
        adapter.AddTabs(new MyTab(category2, donationFragment.newInstance(2, "حملات التبرع")));
        //
        Category category3 = new Category(2, "أوجه التبرع");
        adapter.AddTabs(new MyTab(category3, donation2Fragment.newInstance(3, "أوجه التبرع")));
        //
        Category category4 = new Category(3, "المزيد");
        adapter.AddTabs(new MyTab(category4, MoreFragment.newInstance(4, "المزيد")));
        //
        pager.setAdapter(adapter);
        tab.setupWithViewPager(pager);

        tab.getTabAt(0).setIcon(R.drawable.home);
        tab.getTabAt(1).setIcon(R.drawable.hand);
        tab.getTabAt(2).setIcon(R.drawable.donationess);
        tab.getTabAt(3).setIcon(R.drawable.more);

        BadgeDrawable drawable = tab.getTabAt(0).getOrCreateBadge();
        drawable.setVisible(true);
        drawable.setNumber(1);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Closing Application")
                .setMessage("Are you sure close Application ?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.exit(0);
                    }
                }).setNegativeButton("No", null).show();
    }
}