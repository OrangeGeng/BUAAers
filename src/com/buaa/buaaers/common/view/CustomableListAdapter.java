package com.buaa.buaaers.common.view;

import java.util.ArrayList;
import java.util.List;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * An adapter can be added multiple data items.
 * 
 * @author aaronguo
 */
public class CustomableListAdapter extends BaseAdapter {
	
	private ArrayList<Object> mItems = new ArrayList<Object>();
	private Populator mPopulator;
	
	public CustomableListAdapter(Populator populator) {
		mPopulator = populator;
	}
	
	public CustomableListAdapter(List<?> items, Populator populator) {
		if (items == null) {
			return;
		}
		for (Object o : items) {
			mItems.add(o);
		}
		mPopulator = populator;
	}
	
	public void setPopulator(Populator populator) {
		mPopulator = populator;
	}
	
	/**
	 * Replace the data of adapter with specified items and refresh the list.
	 */
	public void update(List<?> items) {
		clear();
		add(items);
		notifyDataSetChanged();
	}
	
	/**
	 * Replace the data of adapter with specified items and refresh the list.
	 */
	public void update(Object[] items) {
		clear();
		add(items);
		notifyDataSetChanged();
	}
	
	public void add(Object[] items) {
		for (Object item : items) {
			add(item);
		}
	}
	
	public void add(List<?> items) {
		for (Object item : items) {
			add(item);
		}
	}
	
	/**
	 * 添加到指定的位置
	 * @param index
	 * @param item
	 */
	public void add(int index, Object item) {
        if (!mItems.contains(item)) {
            mItems.add(index, item);
        }
    }
	
	public void add(Object item) {
		if (!mItems.contains(item)) {
			mItems.add(item);
		}
	}
	
	public void insert(Object item, int position) {
		mItems.add(position, item);
	}
	
	public void remove(Object item) {
		mItems.remove(item);
	}
	
	public void clear() {
		mItems.clear();
	}
	
	public ArrayList<Object> getItems() {
		return mItems;
	}

	/**
	 * How many items are in the data set represented by this Adapter including headers and footers.
	 */
	@Override
	public int getCount() {
		return mItems.size();
	}

	@Override
	public Object getItem(int position) {
		if (position >= mItems.size()) {
			return null;
		}
		return mItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (mPopulator == null) {
			return null;
		}
		return mPopulator.populate(position, convertView, parent, getItem(position));
	}

}
