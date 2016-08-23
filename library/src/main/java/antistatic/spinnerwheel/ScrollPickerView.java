package antistatic.spinnerwheel;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

import antistatic.spinnerwheel.adapters.NumericWheelAdapter;

/**
 * Created by TCIG_PC_54 on 8/23/2016.
 */

public class ScrollPickerView extends RelativeLayout {
    private AbstractWheel picker;
    private TextView tvName;
    private int minimumValue = 1, maximumValue = 17;
    private NumericWheelAdapter adapter;

    public ScrollPickerView(Context context) {
        super(context);
        init();
    }

    public ScrollPickerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ScrollPickerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public void setMinimumValue(int minimumValue) {
        this.minimumValue = minimumValue;
        adapter.setMinValue(minimumValue);
    }

    public void setMaximumValue(int maximumValue) {
        this.maximumValue = maximumValue;
        adapter.setMaxValue(maximumValue);
    }

    private void init() {
        inflate(getContext(), R.layout.view_scroll_picker, this);
        tvName = (TextView) findViewById(R.id.tvName);
        picker = (AbstractWheel) findViewById(R.id.picker);
        adapter = new NumericWheelAdapter(getContext(), minimumValue, maximumValue) {
            @Override
            public CharSequence getItemText(int index) {
                if (!Util.isRTL()) {
                    return super.getItemText(index);
                }
                if (index >= 0 && index < this.getItemsCount()) {
                    int value = 1 + index;
                    return Util.getLocalNumber(value);
                } else {
                    return null;
                }
            }
        };
        //NumericWheelAdapter hourAdapter = new NumericWheelAdapter(getContext(), 1, 17, "%02d");
        adapter.setItemResource(R.layout.round_wheel_text_centered);
        adapter.setItemTextResource(R.id.text);
        picker.setViewAdapter(adapter);
    }


    public AbstractWheel getPicker() {
        return picker;
    }

    public void appendName(int index) {
        this.tvName.append(" " + Util.getLocalNumber(index));
    }

    public void appendName(String text) {
        this.tvName.append(" " + text);
    }

    public void setName(String text) {
        this.tvName.setText(text);
    }

    public int getCurrentItem() {
        return picker.getCurrentItem();
    }
}

