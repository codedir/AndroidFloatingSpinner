package com.codedir.library;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.ListPopupWindow;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;

/**
 * Created by DEVUSER97 on 7/10/2017.
 */

public class InputSpinner extends AppCompatEditText {
    ListAdapter adapter;
    OnItemSelectedListener onItemSelectedListener;


    public InputSpinner(Context context) {
        super(context);
    }

    public InputSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public InputSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setFocusable(false);
        setClickable(true);
        setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_arrow_drop_down_black_18dp,0);
        setMaxLines(1);
    }

    public interface OnItemSelectedListener {
        void onItemSelectedListener(String item, int selectedIndex);
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.onItemSelectedListener = onItemSelectedListener;
    }

    public void setAdapter(ListAdapter listAdapter){
        adapter = listAdapter;
        popup();
    }

    public void setselection(String selection, int position){
        setText(selection);
        if(onItemSelectedListener != null)
            onItemSelectedListener.onItemSelectedListener(selection,position);

    }

    private void popup(){
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final ListPopupWindow dropdown = new ListPopupWindow(getContext());
                dropdown.setAnchorView(v);
                dropdown.setModal(true);
                dropdown.setAdapter(adapter);
                dropdown.setPromptPosition(ListPopupWindow.POSITION_PROMPT_ABOVE);
                dropdown.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        setselection((String)adapter.getItem(position), position);
                        dropdown.dismiss();
                    }
                });
                dropdown.show();

            }
        });
    }
}
