package archmages.github.databindingsamples.collections;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import archmages.github.databindingsamples.R;
import archmages.github.databindingsamples.databinding.ActivityCollectionBinding;
import archmages.github.databindingsamples.model.User;

/**
 * .
 * <p/>
 *
 * @author <a href="mailto:lmyu@wisorg.com">David.Yu</a>
 * @version V1.0, 17/12/15
 */
public class CollectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollectionBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_collection);
        List<String> strings = new ArrayList<>();
        strings.add("张三");

        SparseArray<String> stringSparseArray = new SparseArray<>();
        stringSparseArray.append(0, "李四");

        HashMap<String, String> map = new HashMap<>();
        map.put("张三", "ZhangSan");

        //复杂类型？
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("王", "五"));

//        binding.setIndex(0);
        binding.setKey("张三");
        binding.setList(strings);
        binding.setSparseArray(stringSparseArray);
        binding.setMap(map);
        binding.setUserList(users);
    }
}
