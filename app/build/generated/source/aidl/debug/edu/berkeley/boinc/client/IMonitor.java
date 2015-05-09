/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /home/cse492/AndroidstudioProjects/BOINC1/app/src/main/aidl/edu/berkeley/boinc/client/IMonitor.aidl
 */
package edu.berkeley.boinc.client;
public interface IMonitor extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements edu.berkeley.boinc.client.IMonitor
{
private static final java.lang.String DESCRIPTOR = "edu.berkeley.boinc.client.IMonitor";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an edu.berkeley.boinc.client.IMonitor interface,
 * generating a proxy if needed.
 */
public static edu.berkeley.boinc.client.IMonitor asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof edu.berkeley.boinc.client.IMonitor))) {
return ((edu.berkeley.boinc.client.IMonitor)iin);
}
return new edu.berkeley.boinc.client.IMonitor.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_attachProject:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
boolean _result = this.attachProject(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_checkProjectAttached:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.checkProjectAttached(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_lookupCredentials:
{
data.enforceInterface(DESCRIPTOR);
edu.berkeley.boinc.rpc.AccountIn _arg0;
if ((0!=data.readInt())) {
_arg0 = edu.berkeley.boinc.rpc.AccountIn.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
edu.berkeley.boinc.rpc.AccountOut _result = this.lookupCredentials(_arg0);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_projectOp:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
java.lang.String _arg1;
_arg1 = data.readString();
boolean _result = this.projectOp(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_resultOp:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
boolean _result = this.resultOp(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_createAccountPolling:
{
data.enforceInterface(DESCRIPTOR);
edu.berkeley.boinc.rpc.AccountIn _arg0;
if ((0!=data.readInt())) {
_arg0 = edu.berkeley.boinc.rpc.AccountIn.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
edu.berkeley.boinc.rpc.AccountOut _result = this.createAccountPolling(_arg0);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_readAuthToken:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _result = this.readAuthToken(_arg0);
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getProjectConfigPolling:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
edu.berkeley.boinc.rpc.ProjectConfig _result = this.getProjectConfigPolling(_arg0);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_addAcctMgrErrorNum:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
int _result = this.addAcctMgrErrorNum(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getAcctMgrInfo:
{
data.enforceInterface(DESCRIPTOR);
edu.berkeley.boinc.rpc.AcctMgrInfo _result = this.getAcctMgrInfo();
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_synchronizeAcctMgr:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.synchronizeAcctMgr(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_setRunMode:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
boolean _result = this.setRunMode(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_setNetworkMode:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
boolean _result = this.setNetworkMode(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getEventLogMessages:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
java.util.List<edu.berkeley.boinc.rpc.Message> _result = this.getEventLogMessages(_arg0, _arg1);
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_getMessages:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
java.util.List<edu.berkeley.boinc.rpc.Message> _result = this.getMessages(_arg0);
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_getNotices:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
java.util.List<edu.berkeley.boinc.rpc.Notice> _result = this.getNotices(_arg0);
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_setCcConfig:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.setCcConfig(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_setGlobalPreferences:
{
data.enforceInterface(DESCRIPTOR);
edu.berkeley.boinc.rpc.GlobalPreferences _arg0;
if ((0!=data.readInt())) {
_arg0 = edu.berkeley.boinc.rpc.GlobalPreferences.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
boolean _result = this.setGlobalPreferences(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_transferOperation:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<edu.berkeley.boinc.rpc.Transfer> _arg0;
_arg0 = data.createTypedArrayList(edu.berkeley.boinc.rpc.Transfer.CREATOR);
int _arg1;
_arg1 = data.readInt();
boolean _result = this.transferOperation(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getServerNotices:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<edu.berkeley.boinc.rpc.Notice> _result = this.getServerNotices();
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_runBenchmarks:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.runBenchmarks();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getAttachableProjects:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<edu.berkeley.boinc.rpc.ProjectInfo> _result = this.getAttachableProjects();
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_getProjectInfo:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
edu.berkeley.boinc.rpc.ProjectInfo _result = this.getProjectInfo(_arg0);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_boincMutexAcquired:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.boincMutexAcquired();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_forceRefresh:
{
data.enforceInterface(DESCRIPTOR);
this.forceRefresh();
reply.writeNoException();
return true;
}
case TRANSACTION_isStationaryDeviceSuspected:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isStationaryDeviceSuspected();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getBatteryChargeStatus:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getBatteryChargeStatus();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getAuthFilePath:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getAuthFilePath();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getBoincPlatform:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getBoincPlatform();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_cancelNoticeNotification:
{
data.enforceInterface(DESCRIPTOR);
this.cancelNoticeNotification();
reply.writeNoException();
return true;
}
case TRANSACTION_getAcctMgrInfoPresent:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.getAcctMgrInfoPresent();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getSetupStatus:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getSetupStatus();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getComputingStatus:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getComputingStatus();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getComputingSuspendReason:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getComputingSuspendReason();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getNetworkSuspendReason:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getNetworkSuspendReason();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getCurrentStatusTitle:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getCurrentStatusTitle();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getCurrentStatusDescription:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getCurrentStatusDescription();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getHostInfo:
{
data.enforceInterface(DESCRIPTOR);
edu.berkeley.boinc.rpc.HostInfo _result = this.getHostInfo();
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_getPrefs:
{
data.enforceInterface(DESCRIPTOR);
edu.berkeley.boinc.rpc.GlobalPreferences _result = this.getPrefs();
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_getProjects:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<edu.berkeley.boinc.rpc.Project> _result = this.getProjects();
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_getClientAcctMgrInfo:
{
data.enforceInterface(DESCRIPTOR);
edu.berkeley.boinc.rpc.AcctMgrInfo _result = this.getClientAcctMgrInfo();
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_getTransfers:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<edu.berkeley.boinc.rpc.Transfer> _result = this.getTransfers();
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_getTasks:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<edu.berkeley.boinc.rpc.Result> _result = this.getTasks();
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_getProjectIconByName:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.graphics.Bitmap _result = this.getProjectIconByName(_arg0);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_getProjectIcon:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.graphics.Bitmap _result = this.getProjectIcon(_arg0);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_getProjectStatus:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _result = this.getProjectStatus(_arg0);
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getRssNotices:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<edu.berkeley.boinc.rpc.Notice> _result = this.getRssNotices();
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_getSlideshowForProject:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.util.List<edu.berkeley.boinc.rpc.ImageWrapper> _result = this.getSlideshowForProject(_arg0);
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_setAutostart:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.setAutostart(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setShowNotificationForNotices:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.setShowNotificationForNotices(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setShowNotificationDuringSuspend:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.setShowNotificationDuringSuspend(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_getShowAdvanced:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.getShowAdvanced();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getAutostart:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.getAutostart();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getShowNotificationForNotices:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.getShowNotificationForNotices();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getShowNotificationDuringSuspend:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.getShowNotificationDuringSuspend();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getLogLevel:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getLogLevel();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_setLogLevel:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.setLogLevel(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setPowerSourceAc:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.setPowerSourceAc(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setPowerSourceUsb:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.setPowerSourceUsb(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setPowerSourceWireless:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.setPowerSourceWireless(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_getStationaryDeviceMode:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.getStationaryDeviceMode();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getPowerSourceAc:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.getPowerSourceAc();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getPowerSourceUsb:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.getPowerSourceUsb();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getPowerSourceWireless:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.getPowerSourceWireless();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_setShowAdvanced:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.setShowAdvanced(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setStationaryDeviceMode:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.setStationaryDeviceMode(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_getSuspendWhenScreenOn:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.getSuspendWhenScreenOn();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_setSuspendWhenScreenOn:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.setSuspendWhenScreenOn(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements edu.berkeley.boinc.client.IMonitor
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/////// client interface //////////////////////////////////////////

@Override public boolean attachProject(java.lang.String url, java.lang.String projectName, java.lang.String authenticator) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(url);
_data.writeString(projectName);
_data.writeString(authenticator);
mRemote.transact(Stub.TRANSACTION_attachProject, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// implement: call clientInterface.attachProject(url, projectName, authenticator);

@Override public boolean checkProjectAttached(java.lang.String url) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(url);
mRemote.transact(Stub.TRANSACTION_checkProjectAttached, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// implement: call clientInterface.checkProjectAttached(url);

@Override public edu.berkeley.boinc.rpc.AccountOut lookupCredentials(edu.berkeley.boinc.rpc.AccountIn credentials) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
edu.berkeley.boinc.rpc.AccountOut _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((credentials!=null)) {
_data.writeInt(1);
credentials.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_lookupCredentials, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = edu.berkeley.boinc.rpc.AccountOut.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// implement: call clientInterface.lookupCredentials(credentials);

@Override public boolean projectOp(int status, java.lang.String url) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(status);
_data.writeString(url);
mRemote.transact(Stub.TRANSACTION_projectOp, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// implement: call clientInterface.projectOp(RpcClient.PROJECT_DETACH,url);

@Override public boolean resultOp(int op, java.lang.String url, java.lang.String name) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(op);
_data.writeString(url);
_data.writeString(name);
mRemote.transact(Stub.TRANSACTION_resultOp, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// implement: call clientInterface.resultOp(int, String, String);

@Override public edu.berkeley.boinc.rpc.AccountOut createAccountPolling(edu.berkeley.boinc.rpc.AccountIn information) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
edu.berkeley.boinc.rpc.AccountOut _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((information!=null)) {
_data.writeInt(1);
information.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_createAccountPolling, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = edu.berkeley.boinc.rpc.AccountOut.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// implement: call clientInterface.createAccountPolling(information);

@Override public java.lang.String readAuthToken(java.lang.String path) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(path);
mRemote.transact(Stub.TRANSACTION_readAuthToken, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// implement: call clientInterface.readAuthToken(String);

@Override public edu.berkeley.boinc.rpc.ProjectConfig getProjectConfigPolling(java.lang.String url) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
edu.berkeley.boinc.rpc.ProjectConfig _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(url);
mRemote.transact(Stub.TRANSACTION_getProjectConfigPolling, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = edu.berkeley.boinc.rpc.ProjectConfig.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// implement: call clientInterface.getProjectConfigPolling(url);

@Override public int addAcctMgrErrorNum(java.lang.String url, java.lang.String userName, java.lang.String pwd) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(url);
_data.writeString(userName);
_data.writeString(pwd);
mRemote.transact(Stub.TRANSACTION_addAcctMgrErrorNum, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// implement: return clientInterface.addAcctMgr(url, userName, pwd).error_num; check return null!=clientInterface.addAcctMgr(url, userName, pwd)

@Override public edu.berkeley.boinc.rpc.AcctMgrInfo getAcctMgrInfo() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
edu.berkeley.boinc.rpc.AcctMgrInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getAcctMgrInfo, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = edu.berkeley.boinc.rpc.AcctMgrInfo.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// implement: call clientInterface.getAcctMgrInfo();

@Override public boolean synchronizeAcctMgr(java.lang.String url) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(url);
mRemote.transact(Stub.TRANSACTION_synchronizeAcctMgr, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// implement: call clientInterface.synchronizeAcctMgr(String);

@Override public boolean setRunMode(int mode) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(mode);
mRemote.transact(Stub.TRANSACTION_setRunMode, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// implement: call clientInterface.setRunMode(Integer);

@Override public boolean setNetworkMode(int mode) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(mode);
mRemote.transact(Stub.TRANSACTION_setNetworkMode, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// implement: call clientInterface.setNetworkMode(Integer);

@Override public java.util.List<edu.berkeley.boinc.rpc.Message> getEventLogMessages(int seq, int num) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<edu.berkeley.boinc.rpc.Message> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(seq);
_data.writeInt(num);
mRemote.transact(Stub.TRANSACTION_getEventLogMessages, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(edu.berkeley.boinc.rpc.Message.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// implement: call clientInterface.getEventLogMessages(int, Integer);

@Override public java.util.List<edu.berkeley.boinc.rpc.Message> getMessages(int seq) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<edu.berkeley.boinc.rpc.Message> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(seq);
mRemote.transact(Stub.TRANSACTION_getMessages, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(edu.berkeley.boinc.rpc.Message.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// implement: call clientInterface.getMessages(Integer);

@Override public java.util.List<edu.berkeley.boinc.rpc.Notice> getNotices(int seq) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<edu.berkeley.boinc.rpc.Notice> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(seq);
mRemote.transact(Stub.TRANSACTION_getNotices, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(edu.berkeley.boinc.rpc.Notice.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// implement: call clientInterface.getNotices(int);

@Override public boolean setCcConfig(java.lang.String config) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(config);
mRemote.transact(Stub.TRANSACTION_setCcConfig, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// implement: call clientInterface.setCcConfig(String);

@Override public boolean setGlobalPreferences(edu.berkeley.boinc.rpc.GlobalPreferences pref) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((pref!=null)) {
_data.writeInt(1);
pref.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_setGlobalPreferences, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// implement: call clientInterface.setGlobalPreferences(GlobalPreferences);

@Override public boolean transferOperation(java.util.List<edu.berkeley.boinc.rpc.Transfer> list, int op) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeTypedList(list);
_data.writeInt(op);
mRemote.transact(Stub.TRANSACTION_transferOperation, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// implement: call clientInterface.transferOperation(ArrayList<transfer>, int);

@Override public java.util.List<edu.berkeley.boinc.rpc.Notice> getServerNotices() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<edu.berkeley.boinc.rpc.Notice> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getServerNotices, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(edu.berkeley.boinc.rpc.Notice.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// implement: call clientInterface.getServerNotices()

@Override public boolean runBenchmarks() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_runBenchmarks, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.util.List<edu.berkeley.boinc.rpc.ProjectInfo> getAttachableProjects() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<edu.berkeley.boinc.rpc.ProjectInfo> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getAttachableProjects, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(edu.berkeley.boinc.rpc.ProjectInfo.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// clientInterface.getAttachableProjects();

@Override public edu.berkeley.boinc.rpc.ProjectInfo getProjectInfo(java.lang.String url) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
edu.berkeley.boinc.rpc.ProjectInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(url);
mRemote.transact(Stub.TRANSACTION_getProjectInfo, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = edu.berkeley.boinc.rpc.ProjectInfo.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// clientInterface.getProjectInfo(String url);
/////// general //////////////////////////////////////////

@Override public boolean boincMutexAcquired() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_boincMutexAcquired, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// implment: call Monitor.boincMutexAcquired();

@Override public void forceRefresh() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_forceRefresh, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// implement: call Monitor.forceRefresh();

@Override public boolean isStationaryDeviceSuspected() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isStationaryDeviceSuspected, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// implement: call Monitor.getDeviceStatus().isStationaryDevice();

@Override public int getBatteryChargeStatus() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getBatteryChargeStatus, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// implement: return getDeviceStatus().getStatus().battery_charge_pct;

@Override public java.lang.String getAuthFilePath() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getAuthFilePath, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// implement: return Monitor.getAuthFilePath();

@Override public int getBoincPlatform() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getBoincPlatform, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// should be not necessary to be implemented as monitor interface

@Override public void cancelNoticeNotification() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_cancelNoticeNotification, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/////// client status //////////////////////////////////////////

@Override public boolean getAcctMgrInfoPresent() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getAcctMgrInfoPresent, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// clientStatus.getAcctMgrInfo().present;

@Override public int getSetupStatus() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getSetupStatus, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// clientStatus.setupStatus;

@Override public int getComputingStatus() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getComputingStatus, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// clientStatus.computingStatus;

@Override public int getComputingSuspendReason() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getComputingSuspendReason, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// clientStatus.computingSuspendReason;

@Override public int getNetworkSuspendReason() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getNetworkSuspendReason, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// clientStatus.networkSuspendReason;

@Override public java.lang.String getCurrentStatusTitle() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getCurrentStatusTitle, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// status.getCurrentStatusTitle()

@Override public java.lang.String getCurrentStatusDescription() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getCurrentStatusDescription, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// status.getCurrentStatusDescription()

@Override public edu.berkeley.boinc.rpc.HostInfo getHostInfo() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
edu.berkeley.boinc.rpc.HostInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getHostInfo, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = edu.berkeley.boinc.rpc.HostInfo.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// clientStatus.getHostInfo()

@Override public edu.berkeley.boinc.rpc.GlobalPreferences getPrefs() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
edu.berkeley.boinc.rpc.GlobalPreferences _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getPrefs, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = edu.berkeley.boinc.rpc.GlobalPreferences.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// clientStatus.getPrefs()

@Override public java.util.List<edu.berkeley.boinc.rpc.Project> getProjects() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<edu.berkeley.boinc.rpc.Project> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getProjects, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(edu.berkeley.boinc.rpc.Project.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// clientStatus.getProjects();

@Override public edu.berkeley.boinc.rpc.AcctMgrInfo getClientAcctMgrInfo() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
edu.berkeley.boinc.rpc.AcctMgrInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getClientAcctMgrInfo, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = edu.berkeley.boinc.rpc.AcctMgrInfo.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// clientStatus.getAcctMgrInfo();                                     

@Override public java.util.List<edu.berkeley.boinc.rpc.Transfer> getTransfers() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<edu.berkeley.boinc.rpc.Transfer> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getTransfers, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(edu.berkeley.boinc.rpc.Transfer.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// clientStatus.getTransfers();

@Override public java.util.List<edu.berkeley.boinc.rpc.Result> getTasks() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<edu.berkeley.boinc.rpc.Result> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getTasks, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(edu.berkeley.boinc.rpc.Result.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// clientStatus.getTasks();

@Override public android.graphics.Bitmap getProjectIconByName(java.lang.String name) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.graphics.Bitmap _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(name);
mRemote.transact(Stub.TRANSACTION_getProjectIconByName, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.graphics.Bitmap.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// clientStatus.getProjectIconByName(entries.get(position).project_name);

@Override public android.graphics.Bitmap getProjectIcon(java.lang.String id) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.graphics.Bitmap _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(id);
mRemote.transact(Stub.TRANSACTION_getProjectIcon, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.graphics.Bitmap.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// clientStatus.getProjectIcon(entries.get(position).id);

@Override public java.lang.String getProjectStatus(java.lang.String url) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(url);
mRemote.transact(Stub.TRANSACTION_getProjectStatus, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// clientStatus.getProjectStatus(url);

@Override public java.util.List<edu.berkeley.boinc.rpc.Notice> getRssNotices() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<edu.berkeley.boinc.rpc.Notice> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getRssNotices, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(edu.berkeley.boinc.rpc.Notice.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// clientStatus.getRssNotices();

@Override public java.util.List<edu.berkeley.boinc.rpc.ImageWrapper> getSlideshowForProject(java.lang.String url) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<edu.berkeley.boinc.rpc.ImageWrapper> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(url);
mRemote.transact(Stub.TRANSACTION_getSlideshowForProject, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(edu.berkeley.boinc.rpc.ImageWrapper.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// clientStatus.getSlideshowForProject(url);
////// app preference ////////////////////////////////////////////

@Override public void setAutostart(boolean isAutoStart) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((isAutoStart)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setAutostart, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// Monitor.getAppPrefs().setAutostart(boolean);

@Override public void setShowNotificationForNotices(boolean isShow) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((isShow)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setShowNotificationForNotices, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// Monitor.getAppPrefs().setShowNotificationForNotices(boolean);

@Override public void setShowNotificationDuringSuspend(boolean isShow) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((isShow)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setShowNotificationDuringSuspend, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// Monitor.getAppPrefs().setShowNotificationDuringSuspend(boolean);

@Override public boolean getShowAdvanced() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getShowAdvanced, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// Monitor.getAppPrefs().getShowAdvanced();

@Override public boolean getAutostart() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getAutostart, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// Monitor.getAppPrefs().getAutostart();

@Override public boolean getShowNotificationForNotices() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getShowNotificationForNotices, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// Monitor.getAppPrefs().getShowNotificationForNotices();

@Override public boolean getShowNotificationDuringSuspend() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getShowNotificationDuringSuspend, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// Monitor.getAppPrefs().getShowNotificationDuringSuspend();

@Override public int getLogLevel() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getLogLevel, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// Monitor.getAppPrefs().getLogLevel();

@Override public void setLogLevel(int level) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(level);
mRemote.transact(Stub.TRANSACTION_setLogLevel, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// Monitor.getAppPrefs().setLogLevel(int);

@Override public void setPowerSourceAc(boolean src) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((src)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setPowerSourceAc, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// Monitor.getAppPrefs().setPowerSourceAc(boolean);

@Override public void setPowerSourceUsb(boolean src) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((src)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setPowerSourceUsb, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// Monitor.getAppPrefs().setPowerSourceUsb(boolean);

@Override public void setPowerSourceWireless(boolean src) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((src)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setPowerSourceWireless, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// Monitor.getAppPrefs().setPowerSourceWireless(boolean);

@Override public boolean getStationaryDeviceMode() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getStationaryDeviceMode, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// Monitor.getAppPrefs().getStationaryDeviceMode();

@Override public boolean getPowerSourceAc() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getPowerSourceAc, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public boolean getPowerSourceUsb() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getPowerSourceUsb, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public boolean getPowerSourceWireless() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getPowerSourceWireless, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void setShowAdvanced(boolean isShow) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((isShow)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setShowAdvanced, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void setStationaryDeviceMode(boolean mode) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((mode)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setStationaryDeviceMode, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public boolean getSuspendWhenScreenOn() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getSuspendWhenScreenOn, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void setSuspendWhenScreenOn(boolean swso) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((swso)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setSuspendWhenScreenOn, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_attachProject = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_checkProjectAttached = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_lookupCredentials = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_projectOp = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_resultOp = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_createAccountPolling = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_readAuthToken = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
static final int TRANSACTION_getProjectConfigPolling = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
static final int TRANSACTION_addAcctMgrErrorNum = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
static final int TRANSACTION_getAcctMgrInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
static final int TRANSACTION_synchronizeAcctMgr = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
static final int TRANSACTION_setRunMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
static final int TRANSACTION_setNetworkMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
static final int TRANSACTION_getEventLogMessages = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
static final int TRANSACTION_getMessages = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
static final int TRANSACTION_getNotices = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
static final int TRANSACTION_setCcConfig = (android.os.IBinder.FIRST_CALL_TRANSACTION + 16);
static final int TRANSACTION_setGlobalPreferences = (android.os.IBinder.FIRST_CALL_TRANSACTION + 17);
static final int TRANSACTION_transferOperation = (android.os.IBinder.FIRST_CALL_TRANSACTION + 18);
static final int TRANSACTION_getServerNotices = (android.os.IBinder.FIRST_CALL_TRANSACTION + 19);
static final int TRANSACTION_runBenchmarks = (android.os.IBinder.FIRST_CALL_TRANSACTION + 20);
static final int TRANSACTION_getAttachableProjects = (android.os.IBinder.FIRST_CALL_TRANSACTION + 21);
static final int TRANSACTION_getProjectInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 22);
static final int TRANSACTION_boincMutexAcquired = (android.os.IBinder.FIRST_CALL_TRANSACTION + 23);
static final int TRANSACTION_forceRefresh = (android.os.IBinder.FIRST_CALL_TRANSACTION + 24);
static final int TRANSACTION_isStationaryDeviceSuspected = (android.os.IBinder.FIRST_CALL_TRANSACTION + 25);
static final int TRANSACTION_getBatteryChargeStatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 26);
static final int TRANSACTION_getAuthFilePath = (android.os.IBinder.FIRST_CALL_TRANSACTION + 27);
static final int TRANSACTION_getBoincPlatform = (android.os.IBinder.FIRST_CALL_TRANSACTION + 28);
static final int TRANSACTION_cancelNoticeNotification = (android.os.IBinder.FIRST_CALL_TRANSACTION + 29);
static final int TRANSACTION_getAcctMgrInfoPresent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 30);
static final int TRANSACTION_getSetupStatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 31);
static final int TRANSACTION_getComputingStatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 32);
static final int TRANSACTION_getComputingSuspendReason = (android.os.IBinder.FIRST_CALL_TRANSACTION + 33);
static final int TRANSACTION_getNetworkSuspendReason = (android.os.IBinder.FIRST_CALL_TRANSACTION + 34);
static final int TRANSACTION_getCurrentStatusTitle = (android.os.IBinder.FIRST_CALL_TRANSACTION + 35);
static final int TRANSACTION_getCurrentStatusDescription = (android.os.IBinder.FIRST_CALL_TRANSACTION + 36);
static final int TRANSACTION_getHostInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 37);
static final int TRANSACTION_getPrefs = (android.os.IBinder.FIRST_CALL_TRANSACTION + 38);
static final int TRANSACTION_getProjects = (android.os.IBinder.FIRST_CALL_TRANSACTION + 39);
static final int TRANSACTION_getClientAcctMgrInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 40);
static final int TRANSACTION_getTransfers = (android.os.IBinder.FIRST_CALL_TRANSACTION + 41);
static final int TRANSACTION_getTasks = (android.os.IBinder.FIRST_CALL_TRANSACTION + 42);
static final int TRANSACTION_getProjectIconByName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 43);
static final int TRANSACTION_getProjectIcon = (android.os.IBinder.FIRST_CALL_TRANSACTION + 44);
static final int TRANSACTION_getProjectStatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 45);
static final int TRANSACTION_getRssNotices = (android.os.IBinder.FIRST_CALL_TRANSACTION + 46);
static final int TRANSACTION_getSlideshowForProject = (android.os.IBinder.FIRST_CALL_TRANSACTION + 47);
static final int TRANSACTION_setAutostart = (android.os.IBinder.FIRST_CALL_TRANSACTION + 48);
static final int TRANSACTION_setShowNotificationForNotices = (android.os.IBinder.FIRST_CALL_TRANSACTION + 49);
static final int TRANSACTION_setShowNotificationDuringSuspend = (android.os.IBinder.FIRST_CALL_TRANSACTION + 50);
static final int TRANSACTION_getShowAdvanced = (android.os.IBinder.FIRST_CALL_TRANSACTION + 51);
static final int TRANSACTION_getAutostart = (android.os.IBinder.FIRST_CALL_TRANSACTION + 52);
static final int TRANSACTION_getShowNotificationForNotices = (android.os.IBinder.FIRST_CALL_TRANSACTION + 53);
static final int TRANSACTION_getShowNotificationDuringSuspend = (android.os.IBinder.FIRST_CALL_TRANSACTION + 54);
static final int TRANSACTION_getLogLevel = (android.os.IBinder.FIRST_CALL_TRANSACTION + 55);
static final int TRANSACTION_setLogLevel = (android.os.IBinder.FIRST_CALL_TRANSACTION + 56);
static final int TRANSACTION_setPowerSourceAc = (android.os.IBinder.FIRST_CALL_TRANSACTION + 57);
static final int TRANSACTION_setPowerSourceUsb = (android.os.IBinder.FIRST_CALL_TRANSACTION + 58);
static final int TRANSACTION_setPowerSourceWireless = (android.os.IBinder.FIRST_CALL_TRANSACTION + 59);
static final int TRANSACTION_getStationaryDeviceMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 60);
static final int TRANSACTION_getPowerSourceAc = (android.os.IBinder.FIRST_CALL_TRANSACTION + 61);
static final int TRANSACTION_getPowerSourceUsb = (android.os.IBinder.FIRST_CALL_TRANSACTION + 62);
static final int TRANSACTION_getPowerSourceWireless = (android.os.IBinder.FIRST_CALL_TRANSACTION + 63);
static final int TRANSACTION_setShowAdvanced = (android.os.IBinder.FIRST_CALL_TRANSACTION + 64);
static final int TRANSACTION_setStationaryDeviceMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 65);
static final int TRANSACTION_getSuspendWhenScreenOn = (android.os.IBinder.FIRST_CALL_TRANSACTION + 66);
static final int TRANSACTION_setSuspendWhenScreenOn = (android.os.IBinder.FIRST_CALL_TRANSACTION + 67);
}
/////// client interface //////////////////////////////////////////

public boolean attachProject(java.lang.String url, java.lang.String projectName, java.lang.String authenticator) throws android.os.RemoteException;
// implement: call clientInterface.attachProject(url, projectName, authenticator);

public boolean checkProjectAttached(java.lang.String url) throws android.os.RemoteException;
// implement: call clientInterface.checkProjectAttached(url);

public edu.berkeley.boinc.rpc.AccountOut lookupCredentials(edu.berkeley.boinc.rpc.AccountIn credentials) throws android.os.RemoteException;
// implement: call clientInterface.lookupCredentials(credentials);

public boolean projectOp(int status, java.lang.String url) throws android.os.RemoteException;
// implement: call clientInterface.projectOp(RpcClient.PROJECT_DETACH,url);

public boolean resultOp(int op, java.lang.String url, java.lang.String name) throws android.os.RemoteException;
// implement: call clientInterface.resultOp(int, String, String);

public edu.berkeley.boinc.rpc.AccountOut createAccountPolling(edu.berkeley.boinc.rpc.AccountIn information) throws android.os.RemoteException;
// implement: call clientInterface.createAccountPolling(information);

public java.lang.String readAuthToken(java.lang.String path) throws android.os.RemoteException;
// implement: call clientInterface.readAuthToken(String);

public edu.berkeley.boinc.rpc.ProjectConfig getProjectConfigPolling(java.lang.String url) throws android.os.RemoteException;
// implement: call clientInterface.getProjectConfigPolling(url);

public int addAcctMgrErrorNum(java.lang.String url, java.lang.String userName, java.lang.String pwd) throws android.os.RemoteException;
// implement: return clientInterface.addAcctMgr(url, userName, pwd).error_num; check return null!=clientInterface.addAcctMgr(url, userName, pwd)

public edu.berkeley.boinc.rpc.AcctMgrInfo getAcctMgrInfo() throws android.os.RemoteException;
// implement: call clientInterface.getAcctMgrInfo();

public boolean synchronizeAcctMgr(java.lang.String url) throws android.os.RemoteException;
// implement: call clientInterface.synchronizeAcctMgr(String);

public boolean setRunMode(int mode) throws android.os.RemoteException;
// implement: call clientInterface.setRunMode(Integer);

public boolean setNetworkMode(int mode) throws android.os.RemoteException;
// implement: call clientInterface.setNetworkMode(Integer);

public java.util.List<edu.berkeley.boinc.rpc.Message> getEventLogMessages(int seq, int num) throws android.os.RemoteException;
// implement: call clientInterface.getEventLogMessages(int, Integer);

public java.util.List<edu.berkeley.boinc.rpc.Message> getMessages(int seq) throws android.os.RemoteException;
// implement: call clientInterface.getMessages(Integer);

public java.util.List<edu.berkeley.boinc.rpc.Notice> getNotices(int seq) throws android.os.RemoteException;
// implement: call clientInterface.getNotices(int);

public boolean setCcConfig(java.lang.String config) throws android.os.RemoteException;
// implement: call clientInterface.setCcConfig(String);

public boolean setGlobalPreferences(edu.berkeley.boinc.rpc.GlobalPreferences pref) throws android.os.RemoteException;
// implement: call clientInterface.setGlobalPreferences(GlobalPreferences);

public boolean transferOperation(java.util.List<edu.berkeley.boinc.rpc.Transfer> list, int op) throws android.os.RemoteException;
// implement: call clientInterface.transferOperation(ArrayList<transfer>, int);

public java.util.List<edu.berkeley.boinc.rpc.Notice> getServerNotices() throws android.os.RemoteException;
// implement: call clientInterface.getServerNotices()

public boolean runBenchmarks() throws android.os.RemoteException;
public java.util.List<edu.berkeley.boinc.rpc.ProjectInfo> getAttachableProjects() throws android.os.RemoteException;
// clientInterface.getAttachableProjects();

public edu.berkeley.boinc.rpc.ProjectInfo getProjectInfo(java.lang.String url) throws android.os.RemoteException;
// clientInterface.getProjectInfo(String url);
/////// general //////////////////////////////////////////

public boolean boincMutexAcquired() throws android.os.RemoteException;
// implment: call Monitor.boincMutexAcquired();

public void forceRefresh() throws android.os.RemoteException;
// implement: call Monitor.forceRefresh();

public boolean isStationaryDeviceSuspected() throws android.os.RemoteException;
// implement: call Monitor.getDeviceStatus().isStationaryDevice();

public int getBatteryChargeStatus() throws android.os.RemoteException;
// implement: return getDeviceStatus().getStatus().battery_charge_pct;

public java.lang.String getAuthFilePath() throws android.os.RemoteException;
// implement: return Monitor.getAuthFilePath();

public int getBoincPlatform() throws android.os.RemoteException;
// should be not necessary to be implemented as monitor interface

public void cancelNoticeNotification() throws android.os.RemoteException;
/////// client status //////////////////////////////////////////

public boolean getAcctMgrInfoPresent() throws android.os.RemoteException;
// clientStatus.getAcctMgrInfo().present;

public int getSetupStatus() throws android.os.RemoteException;
// clientStatus.setupStatus;

public int getComputingStatus() throws android.os.RemoteException;
// clientStatus.computingStatus;

public int getComputingSuspendReason() throws android.os.RemoteException;
// clientStatus.computingSuspendReason;

public int getNetworkSuspendReason() throws android.os.RemoteException;
// clientStatus.networkSuspendReason;

public java.lang.String getCurrentStatusTitle() throws android.os.RemoteException;
// status.getCurrentStatusTitle()

public java.lang.String getCurrentStatusDescription() throws android.os.RemoteException;
// status.getCurrentStatusDescription()

public edu.berkeley.boinc.rpc.HostInfo getHostInfo() throws android.os.RemoteException;
// clientStatus.getHostInfo()

public edu.berkeley.boinc.rpc.GlobalPreferences getPrefs() throws android.os.RemoteException;
// clientStatus.getPrefs()

public java.util.List<edu.berkeley.boinc.rpc.Project> getProjects() throws android.os.RemoteException;
// clientStatus.getProjects();

public edu.berkeley.boinc.rpc.AcctMgrInfo getClientAcctMgrInfo() throws android.os.RemoteException;
// clientStatus.getAcctMgrInfo();                                     

public java.util.List<edu.berkeley.boinc.rpc.Transfer> getTransfers() throws android.os.RemoteException;
// clientStatus.getTransfers();

public java.util.List<edu.berkeley.boinc.rpc.Result> getTasks() throws android.os.RemoteException;
// clientStatus.getTasks();

public android.graphics.Bitmap getProjectIconByName(java.lang.String name) throws android.os.RemoteException;
// clientStatus.getProjectIconByName(entries.get(position).project_name);

public android.graphics.Bitmap getProjectIcon(java.lang.String id) throws android.os.RemoteException;
// clientStatus.getProjectIcon(entries.get(position).id);

public java.lang.String getProjectStatus(java.lang.String url) throws android.os.RemoteException;
// clientStatus.getProjectStatus(url);

public java.util.List<edu.berkeley.boinc.rpc.Notice> getRssNotices() throws android.os.RemoteException;
// clientStatus.getRssNotices();

public java.util.List<edu.berkeley.boinc.rpc.ImageWrapper> getSlideshowForProject(java.lang.String url) throws android.os.RemoteException;
// clientStatus.getSlideshowForProject(url);
////// app preference ////////////////////////////////////////////

public void setAutostart(boolean isAutoStart) throws android.os.RemoteException;
// Monitor.getAppPrefs().setAutostart(boolean);

public void setShowNotificationForNotices(boolean isShow) throws android.os.RemoteException;
// Monitor.getAppPrefs().setShowNotificationForNotices(boolean);

public void setShowNotificationDuringSuspend(boolean isShow) throws android.os.RemoteException;
// Monitor.getAppPrefs().setShowNotificationDuringSuspend(boolean);

public boolean getShowAdvanced() throws android.os.RemoteException;
// Monitor.getAppPrefs().getShowAdvanced();

public boolean getAutostart() throws android.os.RemoteException;
// Monitor.getAppPrefs().getAutostart();

public boolean getShowNotificationForNotices() throws android.os.RemoteException;
// Monitor.getAppPrefs().getShowNotificationForNotices();

public boolean getShowNotificationDuringSuspend() throws android.os.RemoteException;
// Monitor.getAppPrefs().getShowNotificationDuringSuspend();

public int getLogLevel() throws android.os.RemoteException;
// Monitor.getAppPrefs().getLogLevel();

public void setLogLevel(int level) throws android.os.RemoteException;
// Monitor.getAppPrefs().setLogLevel(int);

public void setPowerSourceAc(boolean src) throws android.os.RemoteException;
// Monitor.getAppPrefs().setPowerSourceAc(boolean);

public void setPowerSourceUsb(boolean src) throws android.os.RemoteException;
// Monitor.getAppPrefs().setPowerSourceUsb(boolean);

public void setPowerSourceWireless(boolean src) throws android.os.RemoteException;
// Monitor.getAppPrefs().setPowerSourceWireless(boolean);

public boolean getStationaryDeviceMode() throws android.os.RemoteException;
// Monitor.getAppPrefs().getStationaryDeviceMode();

public boolean getPowerSourceAc() throws android.os.RemoteException;
public boolean getPowerSourceUsb() throws android.os.RemoteException;
public boolean getPowerSourceWireless() throws android.os.RemoteException;
public void setShowAdvanced(boolean isShow) throws android.os.RemoteException;
public void setStationaryDeviceMode(boolean mode) throws android.os.RemoteException;
public boolean getSuspendWhenScreenOn() throws android.os.RemoteException;
public void setSuspendWhenScreenOn(boolean swso) throws android.os.RemoteException;
}
