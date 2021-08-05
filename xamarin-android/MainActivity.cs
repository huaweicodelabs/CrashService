using System;
using Android.App;
using Android.OS;
using Android.Runtime;
using Android.Views;
using AndroidX.AppCompat.Widget;
using AndroidX.AppCompat.App;
using Google.Android.Material.FloatingActionButton;
using Google.Android.Material.Snackbar;
using Android.Widget;
using Huawei.Agconnect.Crash;
using Java.Lang;
using Android;

namespace XamarinAGCDemo
{
    [Activity(Label = "@string/app_name", Theme = "@style/AppTheme.NoActionBar", MainLauncher = true)]
    public class MainActivity : AppCompatActivity
    {
        private Button btnCreateCrash;
        private Button btnCustomReport;
        private Button btnRecordException;


        protected override void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);
            Xamarin.Essentials.Platform.Init(this, savedInstanceState);
            SetContentView(Resource.Layout.activity_main);


            //Init view elements.
            btnCreateCrash = FindViewById<Button>(Resource.Id.btn_crash);
            btnCustomReport = FindViewById<Button>(Resource.Id.btnCustomReport);
            btnRecordException = FindViewById<Button>(Resource.Id.btnRecordException);


            //Events
            btnCreateCrash.Click += BtnCreateCrash_Click;
            btnCustomReport.Click += BtnCustomReport_Click;
            btnRecordException.Click += BtnRecordException_Click;

        }




        private void BtnCreateCrash_Click(object sender, EventArgs e)
        {
            AGConnectCrash.Instance.TestIt(this);
        }


        private void BtnCustomReport_Click(object sender, EventArgs e)
        {
            AGConnectCrash.Instance.SetUserId("testuser");
            AGConnectCrash.Instance.SetCustomKey("doublekey", "1.1");
            AGConnectCrash.Instance.SetCustomKey("floatkey", "1.12f");
            AGConnectCrash.Instance.SetCustomKey("intkey", "123");
            AGConnectCrash.Instance.SetCustomKey("stringkey", "hello world");
            AGConnectCrash.Instance.Log("default log level");
            AGConnectCrash.Instance.Log(3, "3 is debug log level");

        }



        private void BtnRecordException_Click(object sender, EventArgs e)
        {
            try
            {
                ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException();
                throw arrayIndexOutOfBoundsException;
            }
            catch (Java.Lang.Exception ex)
            {
                AGConnectCrash.Instance.RecordException(ex);
            }
        }



    }
}
