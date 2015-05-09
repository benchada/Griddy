// This file is part of BOINC.
// http://boinc.berkeley.edu
// Copyright (C) 2008 University of California
//
// BOINC is free software; you can redistribute it and/or modify it
// under the terms of the GNU Lesser General Public License
// as published by the Free Software Foundation,
// either version 3 of the License, or (at your option) any later version.
//
// BOINC is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
// See the GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with BOINC.  If not, see <http://www.gnu.org/licenses/>.

#if defined(__GNUG__) && !defined(__APPLE__)
#pragma implementation "BOINCGUIApp.h"
#endif

#ifdef __WXMAC__
#include <Carbon/Carbon.h>
#include "filesys.h"
#include "util.h"
#if (defined(SANDBOX) && defined(_DEBUG))
#include "SetupSecurity.h"
#endif
#include "sandbox.h"
#endif

#include "stdwx.h"
#include "diagnostics.h"
#include "network.h"
#include "util.h"
#include "mfile.h"
#include "miofile.h"
#include "parse.h"
#include "idlemon.h"
#include "Events.h"
#include "LogBOINC.h"
#include "BOINCGUIApp.h"
#include "SkinManager.h"
#include "MainDocument.h"
#include "BOINCClientManager.h"
#include "BOINCTaskBar.h"
#include "BOINCBaseFrame.h"
#include "AdvancedFrame.h"
#include "DlgExitMessage.h"
#include "DlgEventLog.h"
#include "procinfo.h"
#include "sg_BoincSimpleFrame.h"


bool s_bSkipExitConfirmation = false;

wxChar* Convert28toISOLangCode[] = 
{
    wxT(""),
    wxT(""),
    wxT("ab"),
    wxT("aa"),
    wxT("af_ZA"),
    wxT("sq_AL"),
    wxT("am"),
    wxT("ar"),
    wxT("ar_DZ"),
    wxT("ar_BH"),
    wxT("ar_EG"),
    wxT("ar_IQ"),
    wxT("ar_JO"),
    wxT("ar_KW"),
    wxT("ar_LB"),
    wxT("ar_LY"),
    wxT("ar_MA"),
    wxT("ar_OM"),
    wxT("ar_QA"),
    wxT("ar_SA"),
    wxT("ar_SD"),
    wxT("ar_SY"),
    wxT("ar_TN"),
    wxT("ar_AE"),
    wxT("ar_YE"),
    wxT("hy"),
    wxT("as"),
    wxT("ay"),
    wxT("az"),
    wxT("az"),
    wxT("az"),
    wxT("ba"),
    wxT("eu_ES"),
    wxT("be_BY"),
    wxT("bn"),
    wxT("dz"),
    wxT("bh"),
    wxT("bi"),
    wxT("br"),
    wxT("bg_BG"),
    wxT("my"),
    wxT("km"),
    wxT("ca_ES"),
    wxT("zh_TW"),
    wxT("zh_CN"),
    wxT("zh_TW"),
    wxT("zh_HK"),
    wxT("zh_MO"),
    wxT("zh_SG"),
    wxT("zh_TW"),
    wxT("co"),
    wxT("hr_HR"),
    wxT("cs_CZ"),
    wxT("da_DK"),
    wxT("nl_NL"),
    wxT("nl_BE"),
    wxT("en_GB"),
    wxT("en_GB"),
    wxT("en_US"),
    wxT("en_AU"),
    wxT("en_BZ"),
    wxT("en_BW"),
    wxT("en_CA"),
    wxT("en_CB"),
    wxT("en_DK"),
    wxT("en_IE"),
    wxT("en_JM"),
    wxT("en_NZ"),
    wxT("en_PH"),
    wxT("en_ZA"),
    wxT("en_TT"),
    wxT("en_ZW"),
    wxT("eo"),
    wxT("et_EE"),
    wxT("fo_FO"),
    wxT("fa_IR"),
    wxT("fj"),
    wxT("fi_FI"),
    wxT("fr_FR"),
    wxT("fr_BE"),
    wxT("fr_CA"),
    wxT("fr_LU"),
    wxT("fr_MC"),
    wxT("fr_CH"),
    wxT("fy"),
    wxT("gl_ES"),
    wxT("ka_GE"),
    wxT("de_DE"),
    wxT("de_AT"),
    wxT("de_BE"),
    wxT("de_LI"),
    wxT("de_LU"),
    wxT("de_CH"),
    wxT("el_GR"),
    wxT("kl_GL"),
    wxT("gn"),
    wxT("gu"),
    wxT("ha"),
    wxT("he_IL"),
    wxT("hi_IN"),
    wxT("hu_HU"),
    wxT("is_IS"),
    wxT("id_ID"),
    wxT("ia"),
    wxT("ie"),
    wxT("iu"),
    wxT("ik"),
    wxT("ga_IE"),
    wxT("it_IT"),
    wxT("it_CH"),
    wxT("ja_JP"),
    wxT("jw"),
    wxT("kn"),
    wxT("ks"),
    wxT("ks_IN"),
    wxT("kk"),
    wxT("kw_GB"),
    wxT("rw"),
    wxT("ky"),
    wxT("rn"),
    wxT(""),
    wxT("ko_KR"),
    wxT("ku_TR"),
    wxT("lo"),
    wxT("la"),
    wxT("lv_LV"),
    wxT("ln"),
    wxT("lt_LT"),
    wxT("mk_MK"),
    wxT("mg"),
    wxT("ms_MY"),
    wxT("ml"),
    wxT("ms_BN"),
    wxT("ms_MY"),
    wxT("mt_MT"),
    wxT(""),
    wxT("mi"),
    wxT("mr_IN"),
    wxT("mo"),
    wxT("mn"),
    wxT("na"),
    wxT("ne_NP"),
    wxT("ne_IN"),
    wxT("nb_NO"),
    wxT("nn_NO"),
    wxT("oc"),
    wxT("or"),
    wxT("om"),
    wxT("ps"),
    wxT("pl_PL"),
    wxT("pt_PT"),
    wxT("pt_BR"),
    wxT("pa"),
    wxT("qu"),
    wxT("rm"),
    wxT("ro_RO"),
    wxT("ru_RU"),
    wxT("ru_UA"),
    wxT("se_NO"),
    wxT("sm"),
    wxT("sg"),
    wxT("sa"),
    wxT("gd"),
    wxT("sr_RS"),
    wxT("sr_RS"),
    wxT("sr_RS@latin"),
    wxT("sr_YU"),
    wxT("sr_YU@latin"),
    wxT("sh"),
    wxT("st"),
    wxT("tn"),
    wxT("sn"),
    wxT("sd"),
    wxT("si"),
    wxT("ss"),
    wxT("sk_SK"),
    wxT("sl_SI"),
    wxT("so"),
    wxT("es_ES"),
    wxT("es_AR"),
    wxT("es_BO"),
    wxT("es_CL"),
    wxT("es_CO"),
    wxT("es_CR"),
    wxT("es_DO"),
    wxT("es_EC"),
    wxT("es_SV"),
    wxT("es_GT"),
    wxT("es_HN"),
    wxT("es_MX"),
    wxT("es_ES"),
    wxT("es_NI"),
    wxT("es_PA"),
    wxT("es_PY"),
    wxT("es_PE"),
    wxT("es_PR"),
    wxT("es_UY"),
    wxT("es_US"),
    wxT("es_VE"),
    wxT("su"),
    wxT("sw_KE"),
    wxT("sv_SE"),
    wxT("sv_FI"),
    wxT("tl_PH"),
    wxT("tg"),
    wxT("ta"),
    wxT("tt"),
    wxT("te"),
    wxT("th_TH"),
    wxT("bo"),
    wxT("ti"),
    wxT("to"),
    wxT("ts"),
    wxT("tr_TR"),
    wxT("tk"),
    wxT("tw"),
    wxT("ug"),
    wxT("uk_UA"),
    wxT("ur"),
    wxT("ur_IN"),
    wxT("ur_PK"),
    wxT("uz"),
    wxT("uz"),
    wxT("uz"),
    wxT("ca_ES@valencia"),
    wxT("vi_VN"),
    wxT("vo"),
    wxT("cy"),
    wxT("wo"),
    wxT("xh"),
    wxT("yi"),
    wxT("yo"),
    wxT("za"),
    wxT("zu")
};


#ifdef __WXMAC__

// Set s_bSkipExitConfirmation to true if cancelled because of logging out or shutting down
OSErr QuitAppleEventHandler( const AppleEvent *appleEvt, AppleEvent* reply, UInt32 refcon ) {
    DescType            senderType;
    Size                actualSize;
    ProcessSerialNumber SenderPSN;
    ProcessInfoRec      pInfo;
    FSSpec              fileSpec;
    OSStatus            anErr;

    // Refuse to quit if a modal dialog is open.  
    // Unfortunately, I know of no way to disable the Quit item in our Dock menu
    if (wxGetApp().IsModalDialogDisplayed()) {
        SysBeep(4);
        return userCanceledErr;
    }
    
    anErr = AEGetAttributePtr(appleEvt, keyAddressAttr, typeProcessSerialNumber,
                                &senderType, &SenderPSN, sizeof(SenderPSN), &actualSize);

    if (anErr == noErr) {
        pInfo.processInfoLength = sizeof( ProcessInfoRec );
        pInfo.processName = NULL;
        pInfo.processAppSpec = &fileSpec;

        anErr = GetProcessInformation(&SenderPSN, &pInfo);

        // Consider a Quit command from our Dock menu as coming from this application
        if ( (pInfo.processSignature != 'dock') && (pInfo.processSignature != 'BNC!') ) {
            s_bSkipExitConfirmation = true; // Not from our app, our dock icon or our taskbar icon
            // The following may no longer be needed under wxCocoa-3.0.0
            wxGetApp().ExitMainLoop();  // Prevents wxMac from issuing events to closed frames
        }
    }
    
    wxCommandEvent evt(wxEVT_COMMAND_MENU_SELECTED, wxID_EXIT);
    wxGetApp().GetFrame()->GetEventHandler()->AddPendingEvent(evt);
    return noErr;
}

#endif


DEFINE_EVENT_TYPE(wxEVT_RPC_FINISHED)

IMPLEMENT_APP(CBOINCGUIApp)
IMPLEMENT_DYNAMIC_CLASS(CBOINCGUIApp, wxApp)

BEGIN_EVENT_TABLE (CBOINCGUIApp, wxApp)
    EVT_ACTIVATE_APP(CBOINCGUIApp::OnActivateApp)
    EVT_RPC_FINISHED(CBOINCGUIApp::OnRPCFinished)
#ifndef __WXMAC__
    EVT_END_SESSION(CBOINCGUIApp::OnEndSession)
#endif
END_EVENT_TABLE ()

bool CBOINCGUIApp::OnInit() {
    // Initialize globals
#ifdef SANDBOX
    g_use_sandbox = true;
#else
    g_use_sandbox = false;
#endif

    s_bSkipExitConfirmation = false;
    m_bFilterEvents = false;
    m_bAboutDialogIsOpen = false;

    // Initialize class variables
    m_pInstanceChecker = NULL;
    m_pLocale = NULL;
    m_pSkinManager = NULL;
    m_pFrame = NULL;
    m_pDocument = NULL;
    m_pTaskBarIcon = NULL;
    m_pEventLog = NULL;
    m_bEventLogWasActive = false;
    m_bProcessingActivateAppEvent = false;
#ifdef __WXMAC__
    m_pMacDockIcon = NULL;
#endif
    m_strBOINCMGRExecutableName = wxEmptyString;
    m_strBOINCMGRRootDirectory = wxEmptyString;
    m_strBOINCMGRDataDirectory = wxEmptyString;
    m_strHostNameArg = wxEmptyString;
    m_strPasswordArg = wxEmptyString;
    m_iRPCPortArg = GUI_RPC_PORT;
    m_strBOINCArguments = wxEmptyString;
    m_strISOLanguageCode = wxEmptyString;
    m_bGUIVisible = true;
    m_bDebugSkins = false;
    m_bMultipleInstancesOK = false;
    m_bBOINCMGRAutoStarted = false;
    m_iBOINCMGRDisableAutoStart = 0;
    m_iShutdownCoreClient = 0;
    m_iDisplayExitDialog = 1;
    m_iGUISelected = BOINC_SIMPLEGUI;
    m_bSafeMessageBoxDisplayed = 0;

    // Initialize local variables
    int      iErrorCode = 0;
    int      iDesiredLanguageCode = 0;
    int      iOldLanguageCode = 0;
    bool     bOpenEventLog = false;
    wxString strDesiredSkinName = wxEmptyString;
    wxString strDialogMessage = wxEmptyString;
    wxString strOldLanguageCode = wxEmptyString;
    bool     success = false;


#ifndef __WXMAC__
    // call this to tell the library to call our OnFatalException()
    wxHandleFatalExceptions();
#endif

    // Configure wxWidgets platform specific code
#ifdef __WXMSW__
    wxSystemOptions::SetOption(wxT("msw.staticbox.optimized-paint"), 0);
#endif
#ifdef __WXMAC__
    bool launchedFromLogin = false;
    
    // In wxMac-2.8.7, default wxListCtrl::RefreshItem() does not work
    // so use traditional generic implementation.
    // This has been fixed in wxMac-2.8.8, but the Mac native implementation:
    //  - takes 3 times the CPU time as the Mac generic version.
    //  - seems to always redraw entire control even if asked to refresh only one row.
    //  - causes major flicker of progress bars, (probably due to full redraws.)
    wxSystemOptions::SetOption(wxT("mac.listctrl.always_use_generic"), 1);

    AEInstallEventHandler( kCoreEventClass, kAEQuitApplication, NewAEEventHandlerUPP((AEEventHandlerProcPtr)QuitAppleEventHandler), 0, false );

    // Cache the current process serial number
    GetCurrentProcess(&m_psnCurrentProcess);
#endif


    // Commandline parsing is done in wxApp::OnInit()
    if (!wxApp::OnInit()) {
        return false;
    }

    if (g_use_sandbox) {
        wxCHANGE_UMASK(2);  // Set file creation mask to be writable by both user and group
                            // Our umask will be inherited by all our child processes
    }

    // Setup application and company information
    SetAppName(wxT("BOINC Manager"));
    SetVendorName(wxT("Space Sciences Laboratory, U.C. Berkeley"));


    // Initialize the configuration storage module
    m_pConfig = new wxConfig(GetAppName());
    wxConfigBase::Set(m_pConfig);
    wxASSERT(m_pConfig);


    // Restore Application State
    m_pConfig->SetPath(wxT("/"));
    m_pConfig->Read(wxT("AutomaticallyShutdownClient"), &m_iShutdownCoreClient, 0L);
    m_pConfig->Read(wxT("DisplayShutdownClientDialog"), &m_iDisplayExitDialog, 1L);
    m_pConfig->Read(wxT("DisableAutoStart"), &m_iBOINCMGRDisableAutoStart, 0L);
    m_pConfig->Read(wxT("Language"), &iOldLanguageCode, 0);
    m_pConfig->Read(wxT("LanguageISO"), &m_strISOLanguageCode, wxT(""));
    m_pConfig->Read(wxT("GUISelection"), &m_iGUISelected, BOINC_SIMPLEGUI);
    m_pConfig->Read(wxT("EventLogOpen"), &bOpenEventLog);


    // Should we abort the BOINC Manager startup process?
    if (m_bBOINCMGRAutoStarted && m_iBOINCMGRDisableAutoStart) {
        return false;
    }

    // Detect where BOINC Manager executable name.
    DetectExecutableName();

    // Detect where BOINC Manager was installed too.
    DetectRootDirectory();

    // Detect where the BOINC Data files are.
    DetectDataDirectory();


    // Switch the current directory to the BOINC Data directory
    if (!GetDataDirectory().IsEmpty()) {
    	success = wxSetWorkingDirectory(GetDataDirectory());
        if (!success) {
            if (!g_use_sandbox) {
                if (!wxDirExists(GetDataDirectory())) {
                    success = wxMkdir(GetDataDirectory(), 0777);    // Does nothing if dir exists
                }
            }
        }
    }

    if (!success) iErrorCode = -1016;

    // Initialize the BOINC Diagnostics Framework
    int dwDiagnosticsFlags =
#ifdef _DEBUG
        BOINC_DIAG_HEAPCHECKENABLED |
        BOINC_DIAG_MEMORYLEAKCHECKENABLED |
#endif
        BOINC_DIAG_DUMPCALLSTACKENABLED | 
        BOINC_DIAG_PERUSERLOGFILES |
        BOINC_DIAG_REDIRECTSTDERR |
        BOINC_DIAG_REDIRECTSTDOUT |
        BOINC_DIAG_TRACETOSTDOUT;

    diagnostics_init(dwDiagnosticsFlags, "stdoutgui", "stderrgui");

    // Enable Logging and Trace Masks
    m_pLog = new wxLogBOINC();
    wxLog::SetActiveTarget(m_pLog);

    m_pLog->AddTraceMask(wxT("Function Start/End"));
    m_pLog->AddTraceMask(wxT("Function Status"));


    // Initialize the internationalization module
#ifdef __WXMSW__
    // On Windows, set all locales for this thread on a per-thread basis
    _configthreadlocale(_ENABLE_PER_THREAD_LOCALE);
#endif
    m_pLocale = new wxLocale();
    wxASSERT(m_pLocale);

    //
    if (m_strISOLanguageCode.IsEmpty()) {
        iDesiredLanguageCode = wxLANGUAGE_DEFAULT;
        if (iOldLanguageCode) {
            strOldLanguageCode = Convert28toISOLangCode[iOldLanguageCode];
            if (!strOldLanguageCode.IsEmpty()) {
                iDesiredLanguageCode = wxLocale::FindLanguageInfo(strOldLanguageCode)->Language;
            }
        }
        m_pLocale->Init(iDesiredLanguageCode);
        m_strISOLanguageCode = m_pLocale->GetCanonicalName();
    } else {
        m_pLocale->Init(wxLocale::FindLanguageInfo(m_strISOLanguageCode)->Language);
    }

    // Look for the localization files by absolute and relative locations.
    //   preference given to the absolute location.
    if (!m_strBOINCMGRRootDirectory.IsEmpty()) {
        m_pLocale->AddCatalogLookupPathPrefix(
            wxString(m_strBOINCMGRRootDirectory + wxT("locale"))
        );
    }
    m_pLocale->AddCatalogLookupPathPrefix(wxT("locale"));
    m_pLocale->AddCatalog(wxT("BOINC-Manager"));
    m_pLocale->AddCatalog(wxT("BOINC-Client"));
    m_pLocale->AddCatalog(wxT("BOINC-Web"));

    InitSupportedLanguages();

    // Note: JAWS for Windows will only speak the context-sensitive
    // help if you use this help provider:
    wxHelpProvider::Set(new wxHelpControllerHelpProvider());

    // Enable known image types
    wxInitAllImageHandlers();

    // Initialize the skin manager
    m_pSkinManager = new CSkinManager(m_bDebugSkins);
    wxASSERT(m_pSkinManager);


    // Load desired manager skin
    m_pConfig->Read(wxT("Skin"), &strDesiredSkinName, m_pSkinManager->GetDefaultSkinName());
    m_pSkinManager->ReloadSkin(strDesiredSkinName);


#ifdef SANDBOX
    // Make sure owners, groups and permissions are correct for the current setting of g_use_sandbox
    char path_to_error[MAXPATHLEN];
    path_to_error[0] = '\0';
    
    if (!iErrorCode) {
#if (defined(__WXMAC__) && defined(_DEBUG))     // TODO: implement this for other platforms
        // GDB can't attach to applications which are running as a different user   
        //  or group, so fix up data with current user and group during debugging
        if (check_security(g_use_sandbox, true, NULL, 0)) {
            CreateBOINCUsersAndGroups();
            SetBOINCDataOwnersGroupsAndPermissions();
            SetBOINCAppOwnersGroupsAndPermissions(NULL);
        }
#endif
        iErrorCode = check_security(
            g_use_sandbox, true, path_to_error, sizeof(path_to_error)
        );
    }

    if (iErrorCode) {

        ShowApplication(true);

        if (iErrorCode == -1099) {
            strDialogMessage.Printf(
                _("You currently are not authorized to manage the client.\n\nTo run %s as this user, please:\n  - reinstall %s answering \"Yes\" to the question about\n     non-administrative users\n or\n  - contact your administrator to add you to the 'boinc_master'\n     user group."),
                m_pSkinManager->GetAdvanced()->GetApplicationShortName().c_str(),
                m_pSkinManager->GetAdvanced()->GetApplicationShortName().c_str()
            );
        } else {
            strDialogMessage.Printf(
                _("%s ownership or permissions are not set properly; please reinstall %s.\n(Error code %d"),
                m_pSkinManager->GetAdvanced()->GetApplicationShortName().c_str(),
                m_pSkinManager->GetAdvanced()->GetApplicationShortName().c_str(),
                iErrorCode
            );
            if (path_to_error[0]) {
                strDialogMessage += _(" at ");
                strDialogMessage += wxString::FromUTF8(path_to_error);
            }
            strDialogMessage += _(")");
            
            fprintf(stderr, "%s\n", (const char*)strDialogMessage.utf8_str());
        }

        wxMessageDialog* pDlg = new wxMessageDialog(
                                    NULL, 
                                    strDialogMessage, 
                                    m_pSkinManager->GetAdvanced()->GetApplicationName(), 
                                    wxOK
                                    );

        pDlg->ShowModal();
        if (pDlg)
            pDlg->Destroy();

        return false;
    }
#endif      // SANDBOX


#ifdef __WXMSW__
    // Perform any last minute checks that should keep the manager
    // from starting up.
    wxString strRebootPendingFile = 
        GetRootDirectory() + wxFileName::GetPathSeparator() + wxT("RebootPending.txt");
    
    if (wxFile::Exists(strRebootPendingFile)) {
        wxMessageDialog dialog(
            NULL,
            _("A reboot is required in order for BOINC to run properly.\nPlease reboot your computer and try again."),
            _("BOINC Manager"),
            wxOK|wxICON_ERROR
        );

        dialog.ShowModal();
        return false;
    }
#endif

#ifdef __WXMAC__
    ProcessSerialNumber psn;
    ProcessInfoRec pInfo;
    OSStatus err;
    
    memset(&pInfo, 0, sizeof(pInfo));
    pInfo.processInfoLength = sizeof( ProcessInfoRec );
    err = GetProcessInformation(&m_psnCurrentProcess, &pInfo);
    if (!err) {
        psn = pInfo.processLauncher;
        memset(&pInfo, 0, sizeof(pInfo));
        pInfo.processInfoLength = sizeof( ProcessInfoRec );
        err = GetProcessInformation(&psn, &pInfo);
    }
    // Don't open main window if we were started automatically at login
    if (pInfo.processSignature == 'lgnw') {  // Login Window app
        launchedFromLogin = true;
        
        // Prevent a situation where wxSingleInstanceChecker lock file
        // from last login auto start (with same pid) was not deleted.
        // This path must match that in DetectDuplicateInstance()
        wxString lockFilePath = wxString(wxFileName::GetHomeDir() +
                                            "/Library/Application Support/BOINC/" +
                                            wxTheApp->GetAppName() +
                                            '-' + wxGetUserId()
                                        );
        boinc_delete_file(lockFilePath.utf8_str());
    }
#endif

    // Detect if BOINC Manager is already running, if so, bring it into the
    // foreground and then exit.
    if (DetectDuplicateInstance()) {
            return false;
    }

    // Initialize the main document
    m_pDocument = new CMainDocument();
    wxASSERT(m_pDocument);

    m_pDocument->OnInit();


    // Is there a condition in which the Simple GUI should not be used?
    if (BOINC_SIMPLEGUI == m_iGUISelected) {
        // Screen too small?
        if (wxGetDisplaySize().GetHeight() < 600) {
            m_iGUISelected = BOINC_ADVANCEDGUI;
        }
    }


    // Initialize the task bar icon
	m_pTaskBarIcon = new CTaskBarIcon(
        m_pSkinManager->GetAdvanced()->GetApplicationName(), 
        m_pSkinManager->GetAdvanced()->GetApplicationIcon(),
        m_pSkinManager->GetAdvanced()->GetApplicationDisconnectedIcon(),
        m_pSkinManager->GetAdvanced()->GetApplicationSnoozeIcon()
#ifdef __WXMAC__
        , wxTBI_CUSTOM_STATUSITEM
#endif
    );
    wxASSERT(m_pTaskBarIcon);
#ifdef __WXMAC__
    m_pMacDockIcon = new CTaskBarIcon(
        m_pSkinManager->GetAdvanced()->GetApplicationName(), 
        m_pSkinManager->GetAdvanced()->GetApplicationIcon(),
        m_pSkinManager->GetAdvanced()->GetApplicationDisconnectedIcon(),
        m_pSkinManager->GetAdvanced()->GetApplicationSnoozeIcon()
        , wxTBI_DOCK
    );
    wxASSERT(m_pMacDockIcon);
#endif

    // Startup the System Idle Detection code
    IdleTrackerAttach();
    
#ifdef __WXMAC__
    if (launchedFromLogin) {
        m_bGUIVisible = false;

        // If the system was just started, we usually get a "Connection
        // failed" error if we try to connect too soon, so delay a bit.
        sleep(10);
    }
#endif

    // Show the UI
    SetActiveGUI(m_iGUISelected, m_bGUIVisible);

    if (!m_bGUIVisible) {
        ShowApplication(false);
	}

    if (bOpenEventLog) {
        DisplayEventLog(m_bGUIVisible);
        if (m_bGUIVisible && m_pFrame) {
            m_pFrame->Raise();
        }
    }
    
    return true;
}

#ifdef __WXMAC__
// We can "show" (unhide) the main window when the
// application is hidden and it won't be visible.
// If we don't do this under wxCocoa 3.0, the Dock 
// icon will bounce (as in notification) when we
// click on our menu bar icon.
// But wxFrame::Show(true) makes the application
// visible again, so we instead call
// m_pFrame->wxWindow::Show() here.
//
// We need to call HideThisApp() after the event
// loop is running, so this is called from
// CBOINCBaseFrame::OnPeriodicRPC() at the first
// firing of ID_PERIODICRPCTIMER.
// 
void CBOINCGUIApp::OnFinishInit() {
    if (!m_bGUIVisible) {
        HideThisApp();
    
        m_pFrame->wxWindow::Show();
        
        if (m_pEventLog) {
            m_pEventLog->wxWindow::Show();
        }
    }
}
#endif


int CBOINCGUIApp::OnExit() {
    // Shutdown the System Idle Detection code
    IdleTrackerDetach();

// Under wxWidgets 2.8.0, the task bar icons
// must be deleted for app to exit its main loop
#ifdef __WXMAC__
    if (m_pMacDockIcon) {
        delete m_pMacDockIcon;
    }
    m_pMacDockIcon = NULL;
#endif
    if (m_pTaskBarIcon) {
        delete m_pTaskBarIcon;
    }
    m_pTaskBarIcon = NULL;

    if (m_pDocument) {
        m_pDocument->OnExit();
        delete m_pDocument;
        m_pDocument = NULL;
    }

    // Save Application State
    SaveState();

    if (m_pSkinManager) {
        delete m_pSkinManager;
        m_pSkinManager = NULL;
    }

    if (m_pLocale) {
        delete m_pLocale;
        m_pLocale = NULL;
    }

    if (m_pEventLog) {
        m_pEventLog->Destroy();
        m_pEventLog = NULL;
    }

    if (m_pInstanceChecker) {
        delete m_pInstanceChecker;
        m_pInstanceChecker = NULL;
    }

    diagnostics_finish();

    return wxApp::OnExit();
}


#ifndef __WXMAC__
// Ensure we shut down gracefully on Windows logout or shutdown
void CBOINCGUIApp::OnEndSession(wxCloseEvent& ) {
    s_bSkipExitConfirmation = true;

    // On Windows Vista with UAC turned on, we have to spawn a new process to change the
    // state of a service.  When Windows is shutting down it'll prevent new processes from
    // being created.  Sometimes it'll present a crash dialog for the newly spawned application.
    //
    // So, we will just let the OS shutdown the service via the service control manager.
    //
    if (m_iShutdownCoreClient && m_pDocument->m_pClientManager->IsBOINCConfiguredAsDaemon()) {
        m_iShutdownCoreClient = false;
    }

    CBOINCBaseFrame* pFrame = wxGetApp().GetFrame();
    wxCommandEvent evt(wxEVT_COMMAND_MENU_SELECTED, wxID_EXIT);
    // The event loop has already been stopped,
    // so we must call OnExit directly
    pFrame->OnExit(evt);
    OnExit();
}


void CBOINCGUIApp::OnFatalException() {
#ifdef wxUSE_DEBUGREPORT 
    wxDebugReportCompress* report = new wxDebugReportCompress;

    if (report->IsOk()) {
        report->AddAll(wxDebugReport::Context_Exception);

        if (report->Process())
        {
            fprintf(
                stderr,
                "ASSERT: Report generated in \"%s\".\n",
                (const char*)report->GetCompressedFileName().mb_str()
            );
            report->Reset();
        }
    }

    delete report;
#endif
}
#endif


void CBOINCGUIApp::SaveState() {
    // Save Application State
    m_pConfig->SetPath(wxT("/"));
    if (m_pSkinManager) {
        m_pConfig->Write(wxT("Skin"), m_pSkinManager->GetSelectedSkin());
    }
    m_pConfig->Write(wxT("LanguageISO"), m_strISOLanguageCode);
    m_pConfig->Write(wxT("AutomaticallyShutdownClient"), m_iShutdownCoreClient);
    m_pConfig->Write(wxT("DisplayShutdownClientDialog"), m_iDisplayExitDialog);
    m_pConfig->Write(wxT("DisableAutoStart"), m_iBOINCMGRDisableAutoStart);
}


///
/// Pass the command line parameters and discriptions to wxWidgets for displaying.
///
void CBOINCGUIApp::OnInitCmdLine(wxCmdLineParser &parser) {
    wxApp::OnInitCmdLine(parser);
    static const wxCmdLineEntryDesc cmdLineDesc[] = {
        { wxCMD_LINE_SWITCH, "a", "autostart", _("BOINC Manager was started by the operating system automatically")},
#if defined(__WXMSW__) || defined(__WXMAC__)
        { wxCMD_LINE_SWITCH, "s", "systray", _("Startup BOINC so only the system tray icon is visible")},
#else
        { wxCMD_LINE_OPTION, "e", "clientdir", _("Directory containing the BOINC Client executable")},
        { wxCMD_LINE_OPTION, "d", "datadir", _("BOINC data directory")},
#endif
        { wxCMD_LINE_OPTION, "n", "namehost", _("Host name or IP address")},
        { wxCMD_LINE_OPTION, "g", "gui_rpc_port", _("GUI RPC port number")},
        { wxCMD_LINE_OPTION, "p", "password", _("Password")},
        { wxCMD_LINE_OPTION, "b", "boincargs", _("Startup BOINC with these optional arguments")},
        { wxCMD_LINE_SWITCH, "i","insecure", _("disable BOINC security users and permissions")},
        { wxCMD_LINE_SWITCH, "c", "checkskins", _("set skin debugging mode to enable skin manager error messages")},
        { wxCMD_LINE_SWITCH, "m", "multiple", _("multiple instances of BOINC Manager allowed")},
#if (defined(__WXMAC__) && defined(_DEBUG))
        { wxCMD_LINE_OPTION, "NSDocumentRevisionsDebugMode", NULL, _("Not used: workaround for bug in XCode 4.2")},
#endif
        { wxCMD_LINE_NONE}  //DON'T forget this line!!
    };
    parser.SetDesc(cmdLineDesc);
}


///
/// Parse command line parameters.
///
bool CBOINCGUIApp::OnCmdLineParsed(wxCmdLineParser &parser) {
    // Give default processing (-?, --help and --verbose) the chance to do something.
    wxApp::OnCmdLineParsed(parser);
    wxString portNum = wxEmptyString;
    long longPort;
    bool hostNameSpecified = false;
    bool passwordSpecified = false;

    parser.Found(wxT("boincargs"), &m_strBOINCArguments);
    if (parser.Found(wxT("autostart"))) {
        m_bBOINCMGRAutoStarted = true;
    }
#if defined(__WXMSW__) || defined(__WXMAC__)
    if (parser.Found(wxT("systray"))) {
        m_bGUIVisible = false;
    }
#endif
    if (parser.Found(wxT("insecure"))) {
        g_use_sandbox = false;
    }
    if (parser.Found(wxT("checkskins"))) {
        m_bDebugSkins = true;
    }
    if (parser.Found(wxT("multiple"))) {
        m_bMultipleInstancesOK = true;
    }

#if !(defined(__WXMSW__) || defined(__WXMAC__))
    if (!parser.Found(wxT("clientdir"), &m_strBOINCMGRRootDirectory)) {
        m_strBOINCMGRRootDirectory = ::wxGetCwd();
    }
    if (m_strBOINCMGRRootDirectory.Last() != '/') {
        m_strBOINCMGRRootDirectory.Append('/');
    }

    if (!parser.Found(wxT("datadir"), &m_strBOINCMGRDataDirectory)) {
        m_strBOINCMGRDataDirectory = m_strBOINCMGRRootDirectory;
    }
    if (m_strBOINCMGRDataDirectory.Last() != '/') {
        m_strBOINCMGRDataDirectory.Append('/');
    }
#endif    

    if (parser.Found(wxT("namehost"), &m_strHostNameArg)) {
        hostNameSpecified = true;
    } else {
        m_strHostNameArg = wxT("localhost");
    }

     if (parser.Found(wxT("gui_rpc_port"), &portNum)) {
        if (portNum.ToLong(&longPort)) {
            m_iRPCPortArg = longPort;
        } else {
            m_iRPCPortArg = GUI_RPC_PORT;  // conversion failed
        }
    } else {
        m_iRPCPortArg = GUI_RPC_PORT;
    }
    
    if (parser.Found(wxT("password"), &m_strPasswordArg)) {
        passwordSpecified = true;
    } else {
        m_strPasswordArg = wxEmptyString;
    }

    if (hostNameSpecified && passwordSpecified) {
        m_bMultipleInstancesOK = true;
    }
    return true;
}


///
/// Detect if another instance of this application is running.
//  Returns true if there is and it is forbidden, otherwise false
//
// We must initialize m_pInstanceChecker even if m_bMultipleInstancesOK
// is true so CMainDocument::OnPoll() can call IsMgrMultipleInstance().
///
bool CBOINCGUIApp::DetectDuplicateInstance() {
#ifdef __WXMAC__
    m_pInstanceChecker = new wxSingleInstanceChecker(
            wxTheApp->GetAppName() + '-' + wxGetUserId(),
            wxFileName::GetHomeDir() + "/Library/Application Support/BOINC"
            );
#else
    m_pInstanceChecker = new wxSingleInstanceChecker();
#endif
    if (m_pInstanceChecker->IsAnotherRunning()) {
        if (m_bMultipleInstancesOK) return false;
#ifdef __WXMSW__
        CTaskBarIcon::FireAppRestore();
#endif
        return true;
    }
    return false;
}


///
/// Determines what name BOINC Manager is called.
///
void CBOINCGUIApp::DetectExecutableName() {
#ifdef __WXMSW__
    TCHAR   szPath[MAX_PATH-1];

    // change the current directory to the boinc install directory
    GetModuleFileName(NULL, szPath, (sizeof(szPath)/sizeof(TCHAR)));
		
    TCHAR *pszProg = _tcsrchr(szPath, '\\');
    if (pszProg) {
        pszProg++;
    }

    // Store the root directory for later use.
    m_strBOINCMGRExecutableName = pszProg;
#endif
}


///
/// Determines where the BOINC Manager is executing from.
///
void CBOINCGUIApp::DetectRootDirectory() {
#ifdef __WXMSW__
    TCHAR   szPath[MAX_PATH-1];

    // change the current directory to the boinc install directory
    GetModuleFileName(NULL, szPath, (sizeof(szPath)/sizeof(TCHAR)));
		
    TCHAR *pszProg = _tcsrchr(szPath, '\\');
    if (pszProg) {
        szPath[pszProg - szPath + 1] = 0;
    }

    // Store the root directory for later use.
    m_strBOINCMGRRootDirectory = szPath;
#endif
}


///
/// Determines where the BOINC data directory is.
///
void CBOINCGUIApp::DetectDataDirectory() {
#ifdef __WXMSW__
    //
    // Determine BOINCMgr Data Directory
    //
	LONG    lReturnValue;
	HKEY    hkSetupHive;
    TCHAR   szPath[MAX_PATH];
    LPTSTR  lpszValue = NULL;
    LPTSTR  lpszExpandedValue = NULL;
    DWORD   dwValueType = REG_EXPAND_SZ;
    DWORD   dwSize = 0;

    // change the current directory to the boinc data directory if it exists
	lReturnValue = RegOpenKeyEx(
        HKEY_LOCAL_MACHINE, 
        _T("SOFTWARE\\Space Sciences Laboratory, U.C. Berkeley\\BOINC Setup"),
		0, 
        KEY_READ,
        &hkSetupHive
    );
    if (lReturnValue == ERROR_SUCCESS) {
        // How large does our buffer need to be?
        lReturnValue = RegQueryValueEx(
            hkSetupHive,
            _T("DATADIR"),
            NULL,
            &dwValueType,
            NULL,
            &dwSize
        );
        if (lReturnValue != ERROR_FILE_NOT_FOUND) {
            // Allocate the buffer space.
            lpszValue = (LPTSTR) malloc(dwSize);
            (*lpszValue) = NULL;

            // Now get the data
            lReturnValue = RegQueryValueEx( 
                hkSetupHive,
                _T("DATADIR"),
                NULL,
                &dwValueType,
                (LPBYTE)lpszValue,
                &dwSize
            );

            // Expand the Strings
            // We need to get the size of the buffer needed
            dwSize = 0;
            lReturnValue = ExpandEnvironmentStrings(lpszValue, NULL, dwSize);
   
            if (lReturnValue) {
                // Make the buffer big enough for the expanded string
                lpszExpandedValue = (LPTSTR) malloc(lReturnValue*sizeof(TCHAR));
                (*lpszExpandedValue) = NULL;
                dwSize = lReturnValue;
   
                ExpandEnvironmentStrings(lpszValue, lpszExpandedValue, dwSize);

                // Store the root directory for later use.
                m_strBOINCMGRDataDirectory = lpszExpandedValue;
            }
        }
    } else {
        if (SUCCEEDED(SHGetFolderPath(NULL, CSIDL_COMMON_APPDATA|CSIDL_FLAG_CREATE, NULL, SHGFP_TYPE_CURRENT, szPath))) {
            _tcsncat(szPath, _T("\\boinc"), ((sizeof(szPath)/sizeof(TCHAR)) - _tcslen(szPath)));
            if (wxDir::Exists(szPath)) {
                // Store the root directory for later use.
                m_strBOINCMGRDataDirectory = szPath;
            }
        }
    }

    // Cleanup
	if (hkSetupHive) RegCloseKey(hkSetupHive);
    if (lpszValue) free(lpszValue);
    if (lpszExpandedValue) free(lpszExpandedValue);
#endif
#ifdef __WXMAC__
    m_strBOINCMGRDataDirectory = wxT("/Library/Application Support/BOINC Data");
#endif
}


void CBOINCGUIApp::InitSupportedLanguages() {
    wxInt32               iIndex = 0;
    const wxLanguageInfo* liLanguage = NULL;

    // Prepare the array
    m_astrLanguages.Insert(wxEmptyString, 0, wxLANGUAGE_USER_DEFINED+1);

    // These are just special tags so deal with them in a special way
    m_astrLanguages[wxLANGUAGE_DEFAULT]                    = _("(Automatic Detection)");
    m_astrLanguages[wxLANGUAGE_UNKNOWN]                    = _("(Unknown)");
    m_astrLanguages[wxLANGUAGE_USER_DEFINED]               = _("(User Defined)");

    for (iIndex = 0; iIndex <= wxLANGUAGE_USER_DEFINED; iIndex++) {
        liLanguage = wxLocale::GetLanguageInfo(iIndex);
        if (liLanguage) {
            m_astrLanguages[iIndex] = liLanguage->Description;
        }
    }
}


int CBOINCGUIApp::IdleTrackerAttach() {
#ifdef __WXMSW__
    ::attach_idle_monitor();
#endif
    return 0;
}


int CBOINCGUIApp::IdleTrackerDetach() {
#ifdef __WXMSW__
    ::detach_idle_monitor();
#endif
    return 0;
}


void CBOINCGUIApp::OnActivateApp(wxActivateEvent& event) {
    m_bProcessingActivateAppEvent = true;

    if (event.GetActive()) {
#ifdef __WXMAC__
        ShowInterface();
#else
#ifdef __WXGTK__
        // Linux allows the Event Log to be brought forward and made active
        // even if we have a modal dialog displayed (associated with our
        // main frame.) This test is needed to allow bringing the modal
        // dialog forward again by clicking on its title bar.
        if (!IsModalDialogDisplayed())
#endif
        {
            bool keepEventLogInFront = m_bEventLogWasActive;
            
            if (m_pEventLog && !m_pEventLog->IsIconized() && !keepEventLogInFront) {
                m_pEventLog->Raise();
            }
            if (m_pFrame) {
                m_pFrame->Raise();
            }
            if (m_pEventLog && !m_pEventLog->IsIconized() && keepEventLogInFront) {
                m_pEventLog->Raise();
            }
        }
#endif
    }

    event.Skip();
    
    m_bProcessingActivateAppEvent = false;
}


void CBOINCGUIApp::OnRPCFinished( CRPCFinishedEvent& event ) {
    CMainDocument*      pDoc = wxGetApp().GetDocument();
   
    wxASSERT(pDoc);
    wxASSERT(wxDynamicCast(pDoc, CMainDocument));
    
    pDoc->OnRPCComplete(event);
}


int CBOINCGUIApp::UpdateSystemIdleDetection() {
#ifdef __WXMSW__
    return get_idle_tick_count();
#else
    return TRUE;
#endif
}


int CBOINCGUIApp::StartBOINCScreensaverTest() {
#ifdef __WXMSW__
    wxString strExecute = wxEmptyString;
    wxChar   szExecutableDirectory[4096];
    memset(szExecutableDirectory, 0, sizeof(szExecutableDirectory));

    // On Windows the screensaver is located in the Windows directory.
    GetWindowsDirectory(
        szExecutableDirectory,
        (sizeof(szExecutableDirectory) / sizeof(wxChar))
    );

    // Append boinc.scr to the end of the strExecute string and get ready to rock
    strExecute = wxT("\"") + wxString(szExecutableDirectory) + wxT("\\boinc.scr\" /t");
    ::wxExecute(strExecute);
#endif
    return 0;
}


int CBOINCGUIApp::StartBOINCDefaultScreensaverTest() {
#ifdef __WXMSW__
    wxString strExecute = wxEmptyString;
    strExecute = wxT("\"") + m_strBOINCMGRRootDirectory + wxT("\\boincscr.exe\" --test");
    ::wxExecute(strExecute);
#endif
    return 0;
}


// Display the Event Log, it is a modeless dialog not owned by
// any other UI element.
// To work around a Linux bug in wxWidgets 3.0 which prevents
// bringing the main frame forward on top of a modeless dialog,
// the Event Log is now a wxFrame on Linux only.
void CBOINCGUIApp::DisplayEventLog(bool bShowWindow) {
    if (m_pEventLog) {
        if (bShowWindow) {
            if (m_pEventLog->IsIconized()) {
                m_pEventLog->Iconize(false);
            }
            m_pEventLog->Raise();
        }
    } else {
        m_pEventLog = new CDlgEventLog();
        if (m_pEventLog) {
                m_pEventLog->Show(bShowWindow);
            if (bShowWindow) {
                m_pEventLog->Raise();
            }
            if (m_pFrame) {
                m_pFrame->UpdateRefreshTimerInterval();
            }
        }
    }
}


void CBOINCGUIApp::OnEventLogClose() {
    m_pEventLog = NULL;
    if (m_pFrame) {
        m_pFrame->UpdateRefreshTimerInterval();
    }
}

    
// The skin has changed and all UI elements need to reload their bitmaps.
//
void CBOINCGUIApp::FireReloadSkin() {
    if (m_pFrame) {
	    m_pFrame->FireReloadSkin();
    }
    if (m_pTaskBarIcon) {
	    m_pTaskBarIcon->FireReloadSkin();
    }
}


bool CBOINCGUIApp::SetActiveGUI(int iGUISelection, bool bShowWindow) {
    wxLogTrace(wxT("Function Start/End"), wxT("CBOINCGUIApp::SetActiveGUI - Function Begin"));
    wxLogTrace(wxT("Function Start/End"), wxT("CBOINCGUIApp::SetActiveGUI - GUI Selection: '%d', Show: %d'"), iGUISelection, (int)bShowWindow);

    CBOINCBaseFrame* pNewFrame = NULL;
    CBOINCBaseFrame* pOldFrame = m_pFrame;
    wxInt32          iTop = 0;
    wxInt32          iLeft = 0;
    wxInt32          iHeight = 0;
    wxInt32          iWidth = 0;


    // Create the new window
    if ((iGUISelection != m_iGUISelected) || !m_pFrame) {

        // Retrieve the desired window state before creating the
        //   desired frames
        if (BOINC_ADVANCEDGUI == iGUISelection) {
            m_pConfig->SetPath(wxT("/"));
            m_pConfig->Read(wxT("YPos"), &iTop, 30);
            m_pConfig->Read(wxT("XPos"), &iLeft, 30);
            m_pConfig->Read(wxT("Width"), &iWidth, 800);
            m_pConfig->Read(wxT("Height"), &iHeight, 600);
            // Guard against a rare situation where registry values are zero
            if (iWidth < 50) iWidth = 800;
            if (iHeight < 50) iHeight = 600;
        } else {
            m_pConfig->SetPath(wxT("/Simple"));
            m_pConfig->Read(wxT("YPos"), &iTop, 30);
            m_pConfig->Read(wxT("XPos"), &iLeft, 30);

            // We don't save Simple View's width & height since it's 
            // window is not resizable, so don't try to read them
#ifdef __WXMAC__
//            m_pConfig->Read(wxT("Width"), &iWidth, 409);
//            m_pConfig->Read(wxT("Height"), &iHeight, 561);
            iWidth = 409;
            iHeight = 561;
#else
//            m_pConfig->Read(wxT("Width"), &iWidth, 416);
//            m_pConfig->Read(wxT("Height"), &iHeight, 570);
            iWidth = 416;
            iHeight = 570;
#endif
        }


        // Make sure that the new window is going to be visible
        //   on a screen
#ifdef __WXMAC__
    if (!IsWindowOnScreen(iLeft, iTop, iWidth, iHeight)) {
        iTop = iLeft = 30;
    }
#else
	    // If either co-ordinate is less then 0 then set it equal to 0 to ensure
	    // it displays on the screen.
	    if ( iLeft < 0 ) iLeft = 30;
	    if ( iTop < 0 ) iTop = 30;

	    // Read the size of the screen
	    wxInt32 iMaxWidth = wxSystemSettings::GetMetric( wxSYS_SCREEN_X );
	    wxInt32 iMaxHeight = wxSystemSettings::GetMetric( wxSYS_SCREEN_Y );

	    // Max sure that it doesn't go off to the right or bottom
	    if ( iLeft + iWidth > iMaxWidth ) iLeft = iMaxWidth - iWidth;
	    if ( iTop + iHeight > iMaxHeight ) iTop = iMaxHeight - iHeight;
#endif

        // Create the main window
        //
        if (BOINC_ADVANCEDGUI == iGUISelection) {
            // Initialize the advanced gui window
            pNewFrame = new CAdvancedFrame(
                m_pSkinManager->GetAdvanced()->GetApplicationName(), 
                m_pSkinManager->GetAdvanced()->GetApplicationIcon(),
                wxPoint(iLeft, iTop),
                wxSize(iWidth, iHeight)
            );
        } else {
            // Initialize the simple gui window
            pNewFrame = new CSimpleFrame(
                m_pSkinManager->GetAdvanced()->GetApplicationName(), 
                m_pSkinManager->GetAdvanced()->GetApplicationIcon(),
                wxPoint(iLeft, iTop),
                wxSize(iWidth, iHeight)
            );
        }

        wxASSERT(pNewFrame);

        if (pNewFrame) {
            SetTopWindow(pNewFrame);

            // Store the new frame for future use
            m_pFrame = pNewFrame;

            // Hide the old one if it exists.  We must do this 
            // after updating m_pFrame to prevent Mac OSX from
            // hiding the application
            if (pOldFrame) pOldFrame->Hide();

            // Delete the old one if it exists
            if (pOldFrame) pOldFrame->Destroy();

            if (iGUISelection != m_iGUISelected) {
                m_iGUISelected = iGUISelection;
                m_pConfig->SetPath(wxT("/"));
                m_pConfig->Write(wxT("GUISelection"), iGUISelection);
                m_pConfig->Flush();
            }
        }
    }

    // Show the new frame if needed 
    if (!m_bProcessingActivateAppEvent) {
        if (m_pFrame && bShowWindow) {
            if (m_pEventLog && !m_pEventLog->IsIconized()) {
                m_pEventLog->Show();
                m_pEventLog->Raise();
    #ifdef __WXMSW__
                ::SetForegroundWindow((HWND)m_pEventLog->GetHWND());
    #endif
            }

            if (!m_pFrame->IsShown()) {
                m_pFrame->Show();
            }
            if (m_pFrame->IsIconized()) {
                m_pFrame->Maximize(false);
            }
            m_pFrame->Raise();

#ifdef __WXMSW__
            ::SetForegroundWindow((HWND)m_pFrame->GetHWND());
#endif
        }
    }

    wxLogTrace(wxT("Function Start/End"), wxT("CBOINCGUIApp::SetActiveGUI - Function End"));
    return true;
}


int CBOINCGUIApp::ConfirmExit() {
    CSkinAdvanced*  pSkinAdvanced = wxGetApp().GetSkinManager()->GetAdvanced();
    CMainDocument*  pDoc = wxGetApp().GetDocument();
    wxString        strConnectedCompter = wxEmptyString;
    bool            bWasVisible;
    int             retval = 0;

    wxASSERT(pDoc);
    wxASSERT(pSkinAdvanced);
    wxASSERT(wxDynamicCast(pDoc, CMainDocument));
    wxASSERT(wxDynamicCast(pSkinAdvanced, CSkinAdvanced));
    
    pDoc->GetConnectedComputerName(strConnectedCompter);
    if (!pDoc->IsComputerNameLocal(strConnectedCompter)) {
        // Don't shut down remote clients on Manager exit
        return 1;
    }

    // Don't run confirmation dialog if logging out or shutting down Mac, 
    // or if emergency exit from AsyncRPCDlg
    if (s_bSkipExitConfirmation) return 1;

    // Don't run confirmation dialog if second instance of Manager 
    if (IsMgrMultipleInstance()) return 1;

    if (!m_iDisplayExitDialog) {
        // Mac: User doesn't want to display the dialog and just wants to use their previous value.
        // Win & Linux: User doesn't want to display the dialog and wants to shutdown the client.
        return 1;
    }

    bWasVisible = IsApplicationVisible();
    ShowApplication(true);

    CDlgExitMessage dlg(NULL);

    if (!pSkinAdvanced->GetExitMessage().IsEmpty()) {
        dlg.m_DialogExitMessage->SetLabel(pSkinAdvanced->GetExitMessage());
    }

#ifdef __WXMSW__
    if (m_iShutdownCoreClient) {
        dlg.m_DialogShutdownCoreClient->SetValue(TRUE);
    }
#endif

    if (m_iDisplayExitDialog) {
        dlg.m_DialogDisplay->SetValue(FALSE);
    }

    dlg.Fit();
    dlg.Centre();

    if (wxID_OK == dlg.ShowModal()) {
#ifdef __WXMAC__
        s_bSkipExitConfirmation = true;     // Don't ask twice (only affects Mac)
#else
        m_iShutdownCoreClient = dlg.m_DialogShutdownCoreClient->GetValue();
#endif
        m_iDisplayExitDialog = !dlg.m_DialogDisplay->GetValue();
        retval = true;

    }

    if (!bWasVisible) {
        ShowApplication(false);
    }

    return retval;       // User cancelled exit
}


// Use this instead of wxMessageBox from all tab Views to suppress 
// Periodic RPCs.  See comment in CMainDocument::RunPeriodicRPCs()
// for a fuller explanation.
int CBOINCGUIApp::SafeMessageBox(const wxString& message, const wxString& caption, long style,
                 wxWindow *parent, int x, int y )
{
    int retval;
    
    m_bSafeMessageBoxDisplayed++;
    
    retval = wxMessageBox(message, caption, style, parent, x, y);

    m_bSafeMessageBoxDisplayed--;

    return retval;
}


#ifndef __WXMAC__
// See clientgui/mac/BOINCGUIApp.mm for the Mac versions.
///
/// Determines if the current process is visible.
///
/// @return
///  true if the current process is visible, otherwise false.
/// 
bool CBOINCGUIApp::IsApplicationVisible() {
    return false;
}

///
/// Shows or hides the current process.
///
/// @param bShow
///   true will show the process, false will hide the process.
///
void CBOINCGUIApp::ShowApplication(bool) {
}
#endif


bool CBOINCGUIApp::ShowInterface() {
    ShowApplication(true);
    return SetActiveGUI(m_iGUISelected, true);
}


bool CBOINCGUIApp::ShowNotifications() {
    bool retval = false;

    retval = SetActiveGUI(m_iGUISelected, true);
    if (retval) {
        GetFrame()->FireNotification();
        GetDocument()->UpdateUnreadNoticeState();
    }

    return retval;
}


bool CBOINCGUIApp::IsModalDialogDisplayed() {
    if (m_bSafeMessageBoxDisplayed) return true;
    
    // Search for the dialog by ID since all of BOINC Manager's 
    // dialog IDs are 10000.
    if (wxDynamicCast(wxWindow::FindWindowById(ID_ANYDIALOG), wxDialog)) {
        return true;
    }
    
    if (m_pDocument) {
        if (m_pDocument->WaitingForRPC()) {
            return true;
        }
    }
    return false;
}

// Prevent recursive entry of CMainDocument::RequestRPC()
int CBOINCGUIApp::FilterEvent(wxEvent &event) {
    int theEventType;
    wxDialog* theRPCWaitDialog;
    wxObject* theObject;

    if (!m_pDocument) return -1;

    theEventType = event.GetEventType();

    if (m_pDocument->WaitingForRPC()) {
        // If in RPC Please Wait dialog, reject all command 
        // and timer events except: 
        //  - RPC Finished
        //  - those for that dialog or its children
        //  - Open Manager menu item from system tray icon

        if ((theEventType == wxEVT_COMMAND_MENU_SELECTED) && (event.GetId() == wxID_OPEN)) {
            return -1;        
        }

        theRPCWaitDialog = m_pDocument->GetRPCWaitDialog();
        theObject = event.GetEventObject();
        while (theObject) {
            if (!theObject->IsKindOf(CLASSINFO(wxWindow))) break;
            if (theObject == theRPCWaitDialog) return -1;
            theObject = ((wxWindow*)theObject)->GetParent();
        }
        // Continue with rest of filtering below
    } else {
        // Do limited filtering if shutting down to allow RPC 
        // completion events but not events which start new RPCs
        if (!m_bFilterEvents) return -1;
    }

    // Allow all except Command, Timer and Mouse Moved events
    if (event.IsCommandEvent()) {
        return false;
    }
    
    if (theEventType == wxEVT_TIMER) {
        return false;
    }
    
#ifdef __WXMSW__
    if (theEventType == wxEVT_TASKBAR_MOVE) {
        return false;
    }
#endif
   
    return -1;
}

