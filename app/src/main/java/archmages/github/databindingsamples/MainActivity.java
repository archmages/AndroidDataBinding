package archmages.github.databindingsamples;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import archmages.github.databindingsamples.alias.AliasBindingActivity;
import archmages.github.databindingsamples.avoidnpe.AvoidNPEActivity;
import archmages.github.databindingsamples.basic.BasicUseActivity;
import archmages.github.databindingsamples.collections.CollectionActivity;
import archmages.github.databindingsamples.custom.CustomBindingActivity;
import archmages.github.databindingsamples.include.IncludeActivity;
import archmages.github.databindingsamples.listitem.ListItemsActivity;
import archmages.github.databindingsamples.showcase.ShowcaseActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openBasicUse(View view){
        startActivity(new Intent(this, BasicUseActivity.class));
    }

    public void openRenameBinding(View view){
        startActivity(new Intent(this, CustomBindingActivity.class));
    }

    public void openAliasBinding(View view){
        startActivity(new Intent(this, AliasBindingActivity.class));
    }

    public void openListItemBinding(View view){
        startActivity(new Intent(this, ListItemsActivity.class));
    }

    public void openIncludeBinding(View view){
        startActivity(new Intent(this, IncludeActivity.class));
    }

    public void openAvoidNPE(View view){
        startActivity(new Intent(this, AvoidNPEActivity.class));
    }

    public void openCollectionBinding(View view){
        startActivity(new Intent(this, CollectionActivity.class));
    }

    public void openyansi(View view){
        startActivity(new Intent(this, ShowcaseActivity.class));
    }
}
