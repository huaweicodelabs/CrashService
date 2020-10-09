//
//  ViewController.m
//  ioscrashdemo
//
//  Created by Support on 2020/9/17.
//  Copyright © 2020 应用市场开发者支撑. All rights reserved.
//

#import "ViewController.h"

#import <AGConnectCrash/AGConnectCrash.h>

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    UIButton * button1 = [UIButton buttonWithType:UIButtonTypeCustom];
    button1.frame = CGRectMake(120, 300, 150, 40);
    [button1 setTitle:@"Make Crash" forState:UIControlStateNormal];
    [button1 setTitleColor:[UIColor blackColor] forState:UIControlStateNormal];
    [button1 addTarget:self action:@selector(crashTest) forControlEvents:UIControlEventTouchUpInside];
    [self.view addSubview:button1];
    
    
    UIButton * button2 = [UIButton buttonWithType:UIButtonTypeCustom];
    button2.frame = CGRectMake(120, 400, 150, 40);
    [button2 setTitle:@"Custom Report" forState:UIControlStateNormal];
    [button2 setTitleColor:[UIColor blackColor] forState:UIControlStateNormal];
    [button2 addTarget:self action:@selector(customreport) forControlEvents:UIControlEventTouchUpInside];
    [self.view addSubview:button2];
    
    
}

- (void)crashTest {
    [[AGCCrash sharedInstance] testIt];
}

- (void)customreport {
    [[AGCCrash sharedInstance] setUserId:@"iosuser"];
    [[AGCCrash sharedInstance] log:@"This is default log"];
    [[AGCCrash sharedInstance] logWithLevel:AGCCrashLogLevelDebug message:@"This is debug log"];
    [[AGCCrash sharedInstance] logWithLevel:AGCCrashLogLevelInfo message:@"This is info log"];
    [[AGCCrash sharedInstance] logWithLevel:AGCCrashLogLevelWarning message:@"This is warning log"];
    [[AGCCrash sharedInstance] logWithLevel:AGCCrashLogLevelError message:@"This is error log"];
    [[AGCCrash sharedInstance] setCustomValue:@"Hello World" forKey:@"This is a World"];
    [[AGCCrash sharedInstance] setCustomValue:@"1234.567" forKey:@"This is a number"];
    
}
@end
