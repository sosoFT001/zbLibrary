package cn.xgy.studing;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import zblibrary.demo.R;
import zuo.biao.library.base.BaseBottomTabActivity;

public class MyBottomTabActivity extends BaseBottomTabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bottom_tab);
    }

    @Override
    protected void selectTab(int position) {

    }

    @Override
    protected int[] getTabClickIds() {
        return new int[0];
    }

    @Override
    protected int[][] getTabSelectIds() {
        return new int[0][];
    }

    @Override
    public int getFragmentContainerResId() {
        return 0;
    }

    @Override
    protected Fragment getFragment(int position) {
        return null;
    }
}
