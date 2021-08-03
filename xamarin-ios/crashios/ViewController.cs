using Foundation;
using System;
using UIKit;
using Huawei.Agconnect.Crash;

namespace crashios0512new
{
    public partial class ViewController : UIViewController
    {
        public ViewController(IntPtr handle) : base(handle)
        {
        }

        public override void ViewDidLoad()
        {
            base.ViewDidLoad();
            // Perform any additional setup after loading the view, typically from a nib.
        }

        public override void DidReceiveMemoryWarning()
        {
            base.DidReceiveMemoryWarning();
            // Release any cached data, images, etc that aren't in use.
        }

        partial void MakeCrash(UIKit.UIButton sender)
        {
            AGCCrash.GetSharedInstance().TestIt();
        }

        partial void CatchException(UIKit.UIButton sender)
        {
            AGCCrash.GetSharedInstance().RecordError(new Foundation.NSError());
        }

        partial void CustomReport(UIKit.UIButton sender)
        {
            AGCCrash.GetSharedInstance().SetUserId("testuser");
            AGCCrash.GetSharedInstance().Log("default info level");
            AGCCrash.GetSharedInstance().SetCustomValue(new NSString("test"), "this is string value");
            AGCCrash.GetSharedInstance().LogWithLevel(AGCCrashLogLevel.Warning, "this is warning log level");
            AGCCrash.GetSharedInstance().SetCustomValue(new NSNumber(123), "this is number");

        }
    }
}
