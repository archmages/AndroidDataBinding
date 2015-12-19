package archmages.github.databindingsamples.listitem;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import archmages.github.databindingsamples.R;
import archmages.github.databindingsamples.databinding.ActivityListItemBinding;

/**
 * .
 * <p/>
 *
 * @author <a href="mailto:lmyu@wisorg.com">David.Yu</a>
 * @version V1.0, 16/12/15
 */
public class ListItemsActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityListItemBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_list_item);
        UserAdapter adapter = new UserAdapter();
        binding.listview.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
