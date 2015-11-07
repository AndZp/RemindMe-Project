package ua.com.ukrelektro.remindme.ui.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import ua.com.ukrelektro.remindme.R;
import ua.com.ukrelektro.remindme.ui.adapters.ListViewAdapter;
import ua.com.ukrelektro.remindme.utils.InitUtil;

public class TabFragment extends Fragment {
    public static final int LAYOUT = R.layout.tab_fragment;
    private View view;
    private ListView listView;
    private ListViewAdapter adapter;

    public static TabFragment getInstanse() {
        Bundle args = new Bundle();
        TabFragment fragment = new TabFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        view = inflater.inflate(LAYOUT, container, false);
        initListView();
        return view;
    }

    private void initListView() {
        listView = (ListView) view.findViewById(R.id.list);

        adapter = new ListViewAdapter(getActivity(), InitUtil.initData());
        listView.setAdapter(adapter);

    }
}
