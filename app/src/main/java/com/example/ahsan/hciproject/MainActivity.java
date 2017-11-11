package com.example.ahsan.hciproject;

        import android.support.v4.view.ViewPager;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.MotionEvent;
        import android.view.ViewParent;
        import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    private ViewFlipper viewFlipper;
    private float lastX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewFlipper = findViewById(R.id.viewflipper);
        viewFlipper.setInAnimation(this, R.anim.in_from_right);
        viewFlipper.setOutAnimation(this, R.anim.out_to_left);
        viewFlipper.setFlipInterval(2000);
        viewFlipper.startFlipping();
    }

    public boolean onTouchEvent(MotionEvent touchevent) {
        switch (touchevent.getAction()) {

            case MotionEvent.ACTION_DOWN: {
                lastX = touchevent.getX();
                break;
            }
            case MotionEvent.ACTION_UP: {
                float currentX = touchevent.getX();

                if (lastX < currentX) {

                    if (viewFlipper.getDisplayedChild() == 0)
                        break;

                    viewFlipper.setInAnimation(this, R.anim.in_from_left);
                    viewFlipper.setOutAnimation(this, R.anim.out_to_right);
                    // Show The Previous Screen
                    viewFlipper.showPrevious();
                }

                // if right to left swipe on screen
                if (lastX > currentX) {
                    if (viewFlipper.getDisplayedChild() == 3)
                        break;

                    viewFlipper.setInAnimation(this, R.anim.in_from_right);
                    viewFlipper.setOutAnimation(this, R.anim.out_to_left);
                    // Show the next Screen
                    viewFlipper.showNext();
                }
                break;
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            viewFlipper.setInAnimation(this, R.anim.in_from_right);
            viewFlipper.setOutAnimation(this, R.anim.out_to_left);
            viewFlipper.setFlipInterval(2000);
            viewFlipper.startFlipping();
        }

        return false;
    }
}