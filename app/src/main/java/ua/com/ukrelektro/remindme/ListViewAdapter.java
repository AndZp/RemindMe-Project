package ua.com.ukrelektro.remindme;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.List;

/**
 * Created by User on 03.11.2015.
 */
public class ListViewAdapter extends ArrayAdapter<String> {

    private List<ReminderObject> data;
    private Context context;

    public ListViewAdapter(Context context, List<ReminderObject> data) {
        super(context, R.layout.my_listview);
        this.data = data;
        this.context = context;
    }


    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public String getItem(int position) {
        // получение одного элемента по индексу
        return data.get(position).getTitle();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // заполнение элементов списка
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // задаем вид элемента списка, который мы создали высше
        View view = inflater.inflate(R.layout.my_listview, parent, false);

        // проставляем данные для элементов
        TextView title = (TextView) view.findViewById(R.id.title);
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, data.get(position).getTitle(), Toast.LENGTH_LONG).show();
            }
        });

        TextView tag = (TextView) view.findViewById(R.id.tag);
        tag.setText(data.get(position).getTag().toString());


        TextView time = (TextView) view.findViewById(R.id.time);


        ImageView thumbImage = (ImageView) view.findViewById(R.id.imageView);
        thumbImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.get(position).setStatus(!data.get(position).getStatus());
                notifyDataSetChanged();
            }
        });

        // получаем элемент со списка
        ReminderObject objectItem = data.get(position);

        // устанавливаем значения компонентам одного эелемента списка
        title.setText(objectItem.getTitle());
        title.setTextColor(Color.DKGRAY);

        DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(context);
        time.setText(dateFormat.format(objectItem.getDate()));

        //TODO Fix image set block


        Drawable image = objectItem.getStatus() ? context.getDrawable(R.drawable.close) : context.getDrawable(R.drawable.open);
        thumbImage.setImageDrawable(image);

        view.setTag(position);

        return view;
    }
}
