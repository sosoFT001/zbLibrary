package cn.xgy.studing;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.StringUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import zblibrary.demo.R;
import zuo.biao.library.base.BaseActivity;
import zuo.biao.library.interfaces.OnBottomDragListener;
import zuo.biao.library.ui.AlertDialog;

public class MyStudingMainActivity extends BaseActivity implements OnBottomDragListener {
    private AlertDialog dialog;

    public static Intent CreateInten(Context context) {
        return new Intent(context, MyStudingMainActivity.class);
    }

    private RecyclerView mRecylist;
    private List<String> mData;
    private BaseQuickAdapter<String, BaseViewHolder> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_studing_main, this);
        initData();
        initView();
        initEvent();







    }

    @Override
    public void initView() {
        mRecylist = findView(R.id.recy_list_mystuding_main);
        mRecylist.setAdapter(mAdapter);
        mRecylist.setLayoutManager(new GridLayoutManager(getActivity(), 1));
    }

    @Override
    public void initData() {
        mData = new ArrayList<>();
        mData.add("MyStudingMainActivity");
        mData.add("MyRecycleListActivity");
        mData.add("sfsd");
        mAdapter = new BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_recy_list_mystuding_main, mData) {
            @Override
            protected void convert(BaseViewHolder helper, String item) {
                if (StringUtils.isSpace(item)) item = "Null data...";
                helper.setText(R.id.btn_title_mystuding, (String) item);
            }
        };
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                String className = null;
                try {
                    className = "cn.xgy.studing." + (String) adapter.getItem(position);
                    Class c = Class.forName(className);
                    Intent intent = new Intent(getActivity(), c);
                    toActivity(intent);
                    LogUtils.d("跳转：className:  " + className);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    showShortToast("unable_to_jump_to_this_data ............err className:" + className);
                    LogUtils.d(Thread.currentThread().getName() + "当前启动无效类名:    " + className);
                } finally {

                }
            }
        });
    }

    private long firstTime = 0;

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                long secondTiem = System.currentTimeMillis();
                if (secondTiem - firstTime > 2000) {
                    firstTime = secondTiem;
                    showShortToast("再按一次后回退!");
                } else {
                    onBackPressed();
                }
                return true;
            case  KeyEvent.KEYCODE_Z:
                showDialog("title:..","message...");
                break;
            case  KeyEvent.KEYCODE_X:
                dismissDialog();
            default:
                break;
        }
        return super.onKeyUp(keyCode, event);
    }


    @Override
    public void initEvent() {

    }

    @Override
    public void onDragBottom(boolean rightToLeft) {
        if (!rightToLeft) {
            LogUtils.d("rightToLeft");
        } else {
            onBackPressed();
        }
    }


    public void showDialog(String sitle,String msg) {
        if (dialog==null) {
             dialog= new AlertDialog(this, sitle, msg, "yes", "no",
                     123, new AlertDialog.OnDialogButtonClickListener() {
                @Override
                public void onDialogButtonClick(int requestCode, boolean isPositive) {
                    if(isPositive){
                        LogUtils.d("点击了确定....");
                    }else {

                    }
                }
            });
             dialog.setContentView(R.layout.dialog_custum);
             dialog.setCanceledOnTouchOutside(false);
        } else {
            if(!dialog.isShowing()) dialog.show();
        }
    }
    public  void dismissDialog(){
        if(dialog!=null&&dialog.isShowing()) dialog.dismiss();
    }
}