package com.example.weike;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;

public class MyScrollLayout extends ViewGroup {

	private VelocityTracker mvelocity;
	private Scroller mscroller;
	private int mCurScreen;
	private int mDefaultScreen = 0;
	private float mLastMotionX;
	private OnViewChangeListener mOnViewChangeListener;

	public MyScrollLayout(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		init(context);
	}
	public MyScrollLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		init(context);
	}

	public MyScrollLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		init(context);
	}

	private void init(Context context) {
		// TODO Auto-generated method stub
		mCurScreen = mDefaultScreen;
		mscroller = new Scroller(context);

	}

	@Override
	protected void onLayout(boolean arg0, int arg1, int arg2, int arg3, int arg4) {
		// TODO Auto-generated method stub
		if (arg0) {
			int childLeft = 0;
			final int childCount = getChildCount();
			for (int i = 0; i < childCount; i++) {
				final View childView = getChildAt(i);
				if (childView.getVisibility() != View.GONE) {
					final int childwidth = childView.getMeasuredWidth();
					childView.layout(childLeft, 0, childLeft + childwidth,
							childView.getMeasuredHeight());
					childLeft += childwidth;
				}
			}
		}

	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		final int width = MeasureSpec.getSize(widthMeasureSpec);
		final int widthMode = MeasureSpec.getMode(widthMeasureSpec);
		final int count = getChildCount();
		for (int i = 0; i < count; i++) {
			getChildAt(i).measure(widthMeasureSpec, heightMeasureSpec);
		}
		scrollTo(mCurScreen * width, 0);
	}

	
	
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		final int action = event.getAction();
		final float x = event.getX();
		final float y = event.getY();
		switch (action) {
		case MotionEvent.ACTION_DOWN:
			Log.i("", "onTouchEvent  ACTION_DOWN");
			if (mvelocity == null) {
				mvelocity = VelocityTracker.obtain();
				mvelocity.addMovement(event);
			}
			if (!mscroller.isFinished()) {
				mscroller.abortAnimation();
			}
			mLastMotionX = x;
			break;

		case MotionEvent.ACTION_MOVE:
			int deltaX = (int) (mLastMotionX - x);
			if (IsCanMove(deltaX)) {
				if (mvelocity != null) {
					mvelocity.addMovement(event);
				}
				mLastMotionX = x;
				scrollBy(deltaX, 0);
			}
			break;
		case MotionEvent.ACTION_UP:
			int velocityX = 0;
			if (mvelocity != null) {
				mvelocity.addMovement(event);
				mvelocity.computeCurrentVelocity(1000);
				velocityX = (int) mvelocity.getXVelocity();
			}
			if (velocityX > 600 && mCurScreen > 0) {
				// Fling enough to move left
				Log.e("ScrollLayout", "snap left");
				snapToScreen(mCurScreen - 1);
			} else if (velocityX < -600 && mCurScreen < getChildCount() - 1) {
				// Fling enough to move right
				Log.e("ScrollLayout", "snap right");
				snapToScreen(mCurScreen + 1);
			} else {
				snapToDestination();
			}
			if (mvelocity != null) {
				mvelocity.recycle();
				mvelocity = null;
			}
			break;
		}
		return true;
	}

	private boolean IsCanMove(int deltaX) {
		// TODO Auto-generated method stub
		if (getScrollX() <= 0 && deltaX < 0) {
			return false;
		}

		if (getScrollX() >= (getChildCount() - 1) * getWidth() && deltaX > 0) {
			return false;
		}

		return true;
	}

	private void snapToDestination() {
		// TODO Auto-generated method stub
		final int screenWidth = getWidth();
		final int destScreen = (getScrollX() + screenWidth / 2) / screenWidth;
		snapToScreen(destScreen);

	}

	private void snapToScreen(int i) {
		// TODO Auto-generated method stub
		i = Math.max(0, Math.min(i, getChildCount() - 1));
		if (getScrollX() != (i * getWidth())) {

			final int delta = i * getWidth() - getScrollX();

			mscroller.startScroll(getScrollX(), 0, delta, 0,
					Math.abs(delta) * 2);

			mCurScreen = i;
			invalidate(); // Redraw the layout

			if (mOnViewChangeListener != null) {
				mOnViewChangeListener.OnViewChange(mCurScreen);
			}
		}

	}
	public void SetOnViewChangeListener(OnViewChangeListener listener) {
		mOnViewChangeListener = listener;
	}
	@Override
	public void computeScroll() {
		// TODO Auto-generated method stub
		if (mscroller.computeScrollOffset()) {
			scrollTo(mscroller.getCurrX(), mscroller.getCurrY());
			postInvalidate();
		}
	}

}

