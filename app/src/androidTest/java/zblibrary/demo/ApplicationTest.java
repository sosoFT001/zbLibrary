package zblibrary.demo;

import android.app.Application;
import android.content.Intent;
import android.os.Looper;
import android.test.ApplicationTestCase;

import com.blankj.utilcode.util.ObjectUtils;

import cn.xgy.studing.MyRecycleListActivity;
import cn.xgy.studing.MyStudingMainActivity;
import zblibrary.demo.activity.AboutActivity;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public static final int ALERT_DIALOG_REQUEST_CODE = 0X123;

    public void startActivity(Class c) {
        if (c == null) {
            return;
        }
        Intent intent = new Intent(getContext(), c);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getContext().startActivity(intent);
    }

    public void startActivity(Intent intent) {
        if (ObjectUtils.isEmpty(intent)) return;
        ;

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getContext().startActivity(intent);
    }

    public ApplicationTest() {
        super(Application.class);
    }
    //  ~~~~~~~~~~~~~~~~~~~~~~


    public void testfun1() {
        String url = "https://weibo.com/";
        startActivity(MyStudingMainActivity.class);
        Looper.loop();

    }

    public  void testfun(){


    }

}
