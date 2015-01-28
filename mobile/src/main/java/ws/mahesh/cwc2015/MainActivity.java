package ws.mahesh.cwc2015;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import it.neokree.materialnavigationdrawer.MaterialNavigationDrawer;
import it.neokree.materialnavigationdrawer.elements.MaterialSection;
import ws.mahesh.cwc2015.fragments.BlankFragment;
import ws.mahesh.cwc2015.fragments.FixturesFragment;
import ws.mahesh.cwc2015.fragments.PointsTableFragment;
import ws.mahesh.cwc2015.fragments.TeamsFragment;
import ws.mahesh.cwc2015.fragments.VenueFragment;


public class MainActivity extends MaterialNavigationDrawer {

    MaterialSection section0,section1, section2, section3, section4,section5, recorder, night, last, settingsSection;

    @Override
    public void init(Bundle savedInstanceState) {
        allowArrowAnimation();
        this.setDrawerHeaderImage(this.getResources().getDrawable(R.drawable.ic_banner_1));


        // create sections
        section0 = this.newSection("Scores",this.getResources().getDrawable(R.drawable.ic_whatshot_black_24dp), new BlankFragment()).setSectionColor(getResources().getColor(R.color.colorRed));

        section1 = this.newSection("Countdown",this.getResources().getDrawable(R.drawable.ic_schedule_black_24dp), new BlankFragment()).setSectionColor(getResources().getColor(R.color.colorPrimary));
        section2 = this.newSection("Teams",this.getResources().getDrawable(R.drawable.ic_group_black_24dp),new TeamsFragment()).setSectionColor(getResources().getColor(R.color.colorGreen));
        section3 = this.newSection("Schedule",this.getResources().getDrawable(R.drawable.ic_event_black_24dp),new FixturesFragment()).setSectionColor(getResources().getColor(R.color.colorPink));
        section4 = this.newSection("Points Table",this.getResources().getDrawable(R.drawable.ic_poll_black_24dp),new PointsTableFragment()).setSectionColor(getResources().getColor(R.color.colorDeepOrange));
        section5 = this.newSection("Venues",this.getResources().getDrawable(R.drawable.ic_public_black_24dp),new VenueFragment()).setSectionColor(getResources().getColor(R.color.colorDeepPurple));
        /* section2 = this.newSection("Section 2",new MaterialSectionListener() {
            @Override
            public void onClick(MaterialSection section) {
                Toast.makeText(NavigationDrawerActivityRipple.this, "Section 2 Clicked", Toast.LENGTH_SHORT).show();

                // deselect section when is clicked
                section.unSelect();
            }
        });
        // recorder section with icon and 10 notifications
        recorder = this.newSection("Recorder",this.getResources().getDrawable(R.drawable.ic_mic_white_24dp),new FragmentIndex()).setNotifications(10);
        // night section with icon, section color and notifications
        night = this.newSection("Night Section", this.getResources().getDrawable(R.drawable.ic_hotel_grey600_24dp), new FragmentIndex())
                .setSectionColor(Color.parseColor("#2196f3"),Color.parseColor("#1565c0")).setNotifications(150);
        // night section with section color
        last = this.newSection("Last Section", new FragmentButton()).setSectionColor(Color.parseColor("#ff9800"), Color.parseColor("#ef6c00"));

        Intent i = new Intent(this,ContactsContract.Profile.class);
        */
        settingsSection = this.newSection("Settings",this.getResources().getDrawable(R.drawable.ic_settings_black_24dp),new BlankFragment());



        // add your sections to the drawer
        this.addSection(section1);
        this.addSection(section0);
        this.addSection(section2);
        this.addSection(section3);
        this.addSection(section4);
        this.addSection(section5);
        /*this.addSubheader("Subheader");
        this.addSection(recorder);
        this.addSection(night);
        this.addDivisor();
        this.addSection(last);
        */
        this.addBottomSection(settingsSection);

        this.setBackPattern(MaterialNavigationDrawer.BACKPATTERN_BACK_TO_FIRST);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_open_playstore) {
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://search?q=pub:" + "Maxx")));
            } catch (android.content.ActivityNotFoundException anfe) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/search?q=pub:" + "Maxx")));
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}