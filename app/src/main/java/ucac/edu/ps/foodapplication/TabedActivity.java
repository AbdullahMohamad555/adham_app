package ucac.edu.ps.foodapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;
import com.michaelmuenzer.android.scrollablennumberpicker.ScrollableNumberPicker;

public class TabedActivity extends AppCompatActivity  {
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

//        View v = View.inflate(getApplicationContext(),R.layout.custum_dialog,null);
//        ScrollableNumberPicker numberPicker = v.findViewById(R.id.scroll_dialog);
//        Button btn = v.findViewById(R.id.btn_dialog);



        switch (item.getItemId()){
            case R.id.don_notification:
                // الانتقال اما على شاشة عرض التبرع في حالة تم التبرع  اما اما في حالة عدم التبرع الانتقال الى شاشة عدم وجود تبرعات
            case R.id.donation:
                showCustomDialog();
        }
        return true;



    }

    void showCustomDialog(){
        final Dialog dialog = new Dialog(TabedActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.custum_dialog);

        ScrollableNumberPicker numberPicker = dialog.findViewById(R.id.scroll_dialog);
        Button btn = dialog.findViewById(R.id.btn_dialog);

        int n_p =numberPicker.getValue();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (n_p>=1){
                    Intent intent = new Intent(getApplicationContext(),Show_donation.class);
                    intent.putExtra("number",n_p);
                    startActivity(intent);
                }else
                    Toast.makeText(TabedActivity.this, "adding donation", Toast.LENGTH_SHORT).show();
            }
        });


        dialog.show();
    }
}