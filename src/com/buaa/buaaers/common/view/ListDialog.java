
package com.buaa.buaaers.common.view;

import com.buaa.buaaers.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;


/**
 * 列表dialog
 * 
 * @author michaelzuo
 */
public class ListDialog extends CustomerDialog {

    /**
     * Dialog中显示的列表
     */
    private ListView listView;

    public ListDialog(Context context) {
        super(context);

        // 列表dialog设置一个默认的title
        setTitle("");
    }

    @Override
    protected View initContentView() {

        View view = LayoutInflater.from(context).inflate(R.layout.listbody, null);
        listView = (ListView)view.findViewById(R.id.list);

        // 只有取消按钮
        getPositiveButton().setVisibility(View.GONE);

        return view;
    }

    /**
     * 设置列表文字
     * 
     * @param list
     */
    public void setList(final String[] list) {
        // 设置adapter
        CustomableListAdapter adapter = new CustomableListAdapter(new Populator() {

            @Override
            public View populate(int position, View convertView, ViewGroup parent, Object item) {
                if (convertView == null) {
                    LayoutInflater inflater = LayoutInflater.from(context);
                    convertView = inflater.inflate(R.layout.listitem_textview, null);
                }

                TextView tv = (TextView)convertView.findViewById(R.id.tv);
                tv.setText(list[position]);

                return convertView;
            }
        });

        adapter.add(list);

        listView.setAdapter(adapter);
    }

    /**
     * 设置列表文字和图标
     * 
     * @param list
     * @param icons
     */
    public void setList(final List<String> list) {
        // 设置adapter
        CustomableListAdapter adapter = new CustomableListAdapter(list, new Populator() {

            @Override
            public View populate(int position, View convertView, ViewGroup parent, Object item) {
                if (convertView == null) {
                    LayoutInflater inflater = LayoutInflater.from(context);
                    convertView = inflater.inflate(R.layout.listitem_textview, null);
                    
                }

                TextView tv = (TextView)convertView.findViewById(R.id.tv);
                tv.setText(list.get(position));

                return convertView;
            }
        });

        listView.setAdapter(adapter);
    }

    /**
     * 设置列表适配器
     * 
     * @param adapter
     */
    public void setAdapter(BaseAdapter adapter) {
        listView.setAdapter(adapter);
    }

    /**
     * 设置item点击监听
     * 
     * @param l
     */
    public void setOnItemClickListener(final OnItemClickListener l) {
        listView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                dismiss();
                l.onItemClick(parent, view, position, id);
            }
        });
    }

}
