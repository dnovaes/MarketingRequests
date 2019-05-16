package petrobahia.example.marketingrequests

import android.content.Intent
import android.widget.Button
import junit.framework.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.Shadows.shadowOf
import petrobahia.marketingrequests.R
import petrobahia.marketingrequests.ui.activities.GraphicPieceActivity
import petrobahia.marketingrequests.ui.activities.MainActivity


@RunWith(RobolectricTestRunner::class)
class GraphicPiecesActivityTest {

    @Test
    @Throws(Exception::class)
    fun testStartButtonFromMainActivity() {
        val mainActivity = Robolectric.setupActivity(MainActivity::class.java)
        mainActivity.findViewById<Button>(R.id.btreqGraphicPiece).performClick();

        val expectedIntent:Intent = Intent(mainActivity, GraphicPieceActivity::class.java)
        val actualIntent:Intent = shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
        assertEquals(expectedIntent.getComponent(), actualIntent.getComponent());

        //assertNotNull(shadowOf(RuntimeEnvironment.application))
        //assertTrue(Robolectric.setupActivity(GraphicPieceActivity::class.java!!) != null)
    }
}
