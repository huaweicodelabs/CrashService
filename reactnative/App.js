/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */
 
import React from 'react';
import type {Node} from 'react';
import { View, Text, Button, StyleSheet } from 'react-native';
import AGCCrash, { LogLevel } from '@react-native-agconnect/crash';


const Separator = () => {
  return <View style={styles.separator} />;
}

export default function App() {
  return (
    <View style={{ marginTop: 250, paddingHorizontal: 50 }}>


  <Separator />
      <Button
        title="MakeCrash"
        onPress={() => {
          AGCCrash.testIt();
        }}
      />
	  
	   
  <Separator />
      <Button
        title="MakeException" 
        onPress={() => {
          try {
            throw new Error("js exception");
        } catch (err) {    
            AGCCrash.recordError(err);
        }
        }}
      />
	  
	  
  <Separator />
      <Button
        title="CustomReport"
        onPress={() =>  {
		  AGCCrash.setUserId('testuser');
          AGCCrash.log('log:This is default log');
          AGCCrash.logWithLevel(LogLevel.DEBUG, 'logWithLevel:DEBUG message DEBUG');
          AGCCrash.logWithLevel(LogLevel.INFO, 'logWithLevel:INFO message INFO');
          AGCCrash.logWithLevel(LogLevel.WARN, 'logWithLevel:WARN message WARN');
          AGCCrash.logWithLevel(LogLevel.ERROR, 'logWithLevel:ERROR message ERROR');
		  AGCCrash.setCustomKey('stringkey', 'Hello world');
          AGCCrash.setCustomKey('booleankey', true);
          AGCCrash.setCustomKey('numberkey', 123.456);
		}}
      />
	  
    </View>
  );
}

const styles = StyleSheet.create({
  separator: {
    marginVertical: 8,
    borderBottomColor: '#737373',
    borderBottomWidth: StyleSheet.hairlineWidth,
  },
});