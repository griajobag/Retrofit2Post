package com.example.putuguna.retrofit2post;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by putuguna on 14/06/16.
 */
public class ExpandAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<FaqModel> listDataHeader;
    private HashMap<FaqModel, FaqModel> listDataChild;

    public ExpandAdapter(Context context, List<FaqModel> listDataHeader, HashMap<FaqModel, FaqModel> listDataChild) {
        this.context = context;
        this.listDataHeader = listDataHeader;
        this.listDataChild = listDataChild;
    }

    @Override
    public int getGroupCount() {
        return this.listDataHeader.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.listDataHeader.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.listDataChild.get(this.listDataHeader.get(groupPosition));
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        FaqModel headerItem = (FaqModel) getGroup(groupPosition);
        Holder holder;


        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_question, parent,false);
            holder = new Holder();
            holder.question = (TextView) convertView.findViewById(R.id.lblListHeader);
            convertView.setTag(holder);
        }else{
            holder = (Holder) convertView.getTag();
        }

        holder.question.setText(headerItem.getQuestion());

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        FaqModel headerItem = (FaqModel) getGroup(groupPosition);
        Holder holder;


        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_json, parent,false);
            holder = new Holder();
            holder.answer = (TextView) convertView.findViewById(R.id.lblListItem);
            convertView.setTag(holder);
        }else{
            holder = (Holder) convertView.getTag();
        }

        holder.answer.setText(headerItem.getAnswer());

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    static class Holder{
        TextView question;
        TextView answer;
    }
}
