/*
    Copyright 2012 Mega-Mario

    This file is part of Whitehole.

    Whitehole is free software: you can redistribute it and/or modify it under
    the terms of the GNU General Public License as published by the Free
    Software Foundation, either version 3 of the License, or (at your option)
    any later version.

    Whitehole is distributed in the hope that it will be useful, but WITHOUT ANY 
    WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS 
    FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along 
    with Whitehole. If not, see http://www.gnu.org/licenses/.
*/

package whitehole;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.*;
import whitehole.vectors.*;
import whitehole.rendering.*;
import whitehole.smg.*;
import whitehole.fileio.*;

/**
 *
 * @author lolol
 */
public class GalaxyEditorForm extends javax.swing.JFrame
{

    /**
     * Creates new form GalaxyEditorForm
     */
    public GalaxyEditorForm(String galaxy)
    {
        initComponents();

        galaxyName = galaxy;
        try
        {
            galaxyArc = Whitehole.game.openGalaxy(galaxyName);
        }
        catch (IOException ex)
        {
            JOptionPane.showMessageDialog(this, "Failed to open the galaxy: "+ex.getMessage(), Whitehole.name, JOptionPane.ERROR_MESSAGE);
            dispose();
            return;
        }
        
        setTitle(galaxyName + " - " + Whitehole.fullName);
        setIconImage(Toolkit.getDefaultToolkit().createImage(Whitehole.class.getResource("/Resources/icon.png")));

        GLCanvas glc = new GLCanvas();
        glc.addGLEventListener(renderer = new GalaxyRenderer(this));
        glc.addMouseListener(renderer);
        glc.addMouseMotionListener(renderer);
        glc.addMouseWheelListener(renderer);
        
        //pnlGLPanel.setLayout(new BorderLayout());
        pnlGLPanel.add(glc, BorderLayout.CENTER);
        //pnlGLPanel.doLayout();
        //pnlGLPanel.add(glc);
        pnlGLPanel.validate();
        
        DefaultListModel scenlist = new DefaultListModel();
        lbScenarioList.setModel(scenlist);
        for (Bcsv.Entry scen : galaxyArc.scenarioData)
        {
            scenlist.addElement(String.format("[%1$d] %2$s", (int)scen.get("ScenarioNo"), (String)scen.get("ScenarioName")));
        }
        
        lbScenarioList.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnSave = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jSplitPane1 = new javax.swing.JSplitPane();
        pnlGLPanel = new javax.swing.JPanel();
        jToolBar2 = new javax.swing.JToolBar();
        jLabel2 = new javax.swing.JLabel();
        lbStatusLabel = new javax.swing.JLabel();
        tpLeftPanel = new javax.swing.JTabbedPane();
        jSplitPane3 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jToolBar3 = new javax.swing.JToolBar();
        jLabel3 = new javax.swing.JLabel();
        btnAddScenario = new javax.swing.JButton();
        btnEditScenario = new javax.swing.JButton();
        btnDeleteScenario = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lbScenarioList = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        jToolBar4 = new javax.swing.JToolBar();
        jLabel4 = new javax.swing.JLabel();
        btnAddZone = new javax.swing.JButton();
        btnDeleteZone = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lbZoneList = new javax.swing.JList();
        jSplitPane4 = new javax.swing.JSplitPane();
        jPanel3 = new javax.swing.JPanel();
        jToolBar5 = new javax.swing.JToolBar();
        jLabel5 = new javax.swing.JLabel();
        btnAddObject = new javax.swing.JButton();
        btnDeleteObject = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tvObjectList = new javax.swing.JTree();
        pnlObjectSettings = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnSave.setText("Save");
        btnSave.setFocusable(false);
        btnSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnSave);
        jToolBar1.add(jSeparator1);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        jSplitPane1.setDividerLocation(200);
        jSplitPane1.setLastDividerLocation(200);

        pnlGLPanel.setMinimumSize(new java.awt.Dimension(10, 10));
        pnlGLPanel.setLayout(new java.awt.BorderLayout());

        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);

        jLabel2.setText("toolbar placeholder :D");
        jToolBar2.add(jLabel2);

        pnlGLPanel.add(jToolBar2, java.awt.BorderLayout.NORTH);

        lbStatusLabel.setText("status text goes here");
        pnlGLPanel.add(lbStatusLabel, java.awt.BorderLayout.PAGE_END);

        jSplitPane1.setRightComponent(pnlGLPanel);

        tpLeftPanel.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        tpLeftPanel.setMinimumSize(new java.awt.Dimension(100, 5));

        jSplitPane3.setDividerLocation(200);
        jSplitPane3.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane3.setLastDividerLocation(200);

        jPanel1.setPreferredSize(new java.awt.Dimension(201, 200));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jToolBar3.setFloatable(false);
        jToolBar3.setRollover(true);

        jLabel3.setText("Scenarios:");
        jToolBar3.add(jLabel3);

        btnAddScenario.setText("Add");
        btnAddScenario.setFocusable(false);
        btnAddScenario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAddScenario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(btnAddScenario);

        btnEditScenario.setText("Edit");
        btnEditScenario.setFocusable(false);
        btnEditScenario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditScenario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(btnEditScenario);

        btnDeleteScenario.setText("Delete");
        btnDeleteScenario.setFocusable(false);
        btnDeleteScenario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDeleteScenario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(btnDeleteScenario);

        jPanel1.add(jToolBar3, java.awt.BorderLayout.PAGE_START);

        lbScenarioList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lbScenarioList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lbScenarioListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lbScenarioList);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jSplitPane3.setTopComponent(jPanel1);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jToolBar4.setFloatable(false);
        jToolBar4.setRollover(true);

        jLabel4.setText("Zones:");
        jToolBar4.add(jLabel4);

        btnAddZone.setText("Add");
        btnAddZone.setFocusable(false);
        btnAddZone.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAddZone.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar4.add(btnAddZone);

        btnDeleteZone.setText("Delete");
        btnDeleteZone.setFocusable(false);
        btnDeleteZone.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDeleteZone.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar4.add(btnDeleteZone);

        jPanel2.add(jToolBar4, java.awt.BorderLayout.PAGE_START);

        lbZoneList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lbZoneList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lbZoneListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lbZoneList);

        jPanel2.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jSplitPane3.setRightComponent(jPanel2);

        tpLeftPanel.addTab("Scenario/Zone", jSplitPane3);

        jSplitPane4.setDividerLocation(300);
        jSplitPane4.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane4.setFocusCycleRoot(true);
        jSplitPane4.setLastDividerLocation(300);

        jPanel3.setPreferredSize(new java.awt.Dimension(149, 300));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jToolBar5.setFloatable(false);
        jToolBar5.setRollover(true);

        jLabel5.setText("Objects:");
        jToolBar5.add(jLabel5);

        btnAddObject.setText("Add");
        btnAddObject.setFocusable(false);
        btnAddObject.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAddObject.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar5.add(btnAddObject);

        btnDeleteObject.setText("Delete");
        btnDeleteObject.setFocusable(false);
        btnDeleteObject.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDeleteObject.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar5.add(btnDeleteObject);

        jPanel3.add(jToolBar5, java.awt.BorderLayout.PAGE_START);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        tvObjectList.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane3.setViewportView(tvObjectList);

        jPanel3.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jSplitPane4.setTopComponent(jPanel3);

        pnlObjectSettings.setLayout(new java.awt.GridLayout(1, 2));
        jSplitPane4.setRightComponent(pnlObjectSettings);

        tpLeftPanel.addTab("Objects", jSplitPane4);

        jSplitPane1.setLeftComponent(tpLeftPanel);

        getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowOpened
    {//GEN-HEADEREND:event_formWindowOpened
        //
    }//GEN-LAST:event_formWindowOpened

    private void lbScenarioListValueChanged(javax.swing.event.ListSelectionEvent evt)//GEN-FIRST:event_lbScenarioListValueChanged
    {//GEN-HEADEREND:event_lbScenarioListValueChanged
        if (evt.getValueIsAdjusting())
        {
            return;
        }
        if (lbScenarioList.getSelectedValue() == null)
        {
            return;
        }

        DefaultListModel zonelist = new DefaultListModel();
        lbZoneList.setModel(zonelist);
        for (String zone : galaxyArc.zoneList)
        {
            String layerstr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ------";
            int layermask = (int) galaxyArc.scenarioData.get(lbScenarioList.getSelectedIndex()).get(zone);
            String layers = "";
            for (int i = 0; i < 32; i++)
            {
                if ((layermask & (1 << i)) != 0)
                {
                    layers += layerstr.charAt(i);
                }
            }
            if (layers.equals(""))
            {
                layers = "none";
            }

            zonelist.addElement(zone + " [" + layers + "]");
        }

        lbZoneList.setSelectedIndex(0);
    }//GEN-LAST:event_lbScenarioListValueChanged

    private void lbZoneListValueChanged(javax.swing.event.ListSelectionEvent evt)//GEN-FIRST:event_lbZoneListValueChanged
    {//GEN-HEADEREND:event_lbZoneListValueChanged
        if (evt.getValueIsAdjusting())
        {
            return;
        }
        if (lbZoneList.getSelectedValue() == null)
        {
            return;
        }

        int selid = lbZoneList.getSelectedIndex();
        lbStatusLabel.setText("Editing scenario " + lbScenarioList.getSelectedValue() + ", zone " + galaxyArc.zoneList.get(selid));
    }//GEN-LAST:event_lbZoneListValueChanged

    
    public class GalaxyRenderer implements GLEventListener, MouseListener, MouseMotionListener, MouseWheelListener
    {
        public GalaxyRenderer(GalaxyEditorForm parent)
        {
            super();
            this.parent = parent;
        }
        
        @Override
        public void init(GLAutoDrawable glad)
        {
            GL2 gl = glad.getGL().getGL2();
            
            lastMouseMove = new Point(-1, -1);
            
            renderinfo = new GLRenderer.RenderInfo();
            renderinfo.drawable = glad;
            renderinfo.renderMode = GLRenderer.RenderMode.OPAQUE;
            
            try { 
                String objname = "IceMountainPlanet";
                RarcFilesystem arc = new RarcFilesystem(Whitehole.game.filesystem.openFile("/ObjectData/"+objname+".arc"));
                testmodel = new Bmd(arc.openFile("/"+objname+"/"+objname+".bdl")); 
            } catch (IOException ex) {}
            testrenderer = new BmdRenderer(renderinfo, testmodel);
            
            camDistance = 1f;
            camRotation = new Vector2(0f, 0f);
            camTarget = new Vector3(0f, 0f, 0f);
            camPosition = new Vector3(0f, 0f, 0f);
            updateCamera();
            
            //gl.glClearColor(0f, 1f, 0f, 1f);
            gl.glFrontFace(GL2.GL_CW);
        }

        @Override
        public void dispose(GLAutoDrawable glad)
        {
            GL2 gl = glad.getGL().getGL2();
            
            // dispose objects here
        }

        @Override
        public void display(GLAutoDrawable glad)
        {
            GL2 gl = glad.getGL().getGL2();
            
            gl.glClearColor(0f, 0f, 0.125f, 1f);
            gl.glClearDepth(1f);
            gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
            
            gl.glMatrixMode(GL2.GL_MODELVIEW);
            gl.glLoadMatrixf(modelViewMatrix.m, 0);
            //gl.glScalef(0.0001f, 0.0001f, 0.0001f);
            
            gl.glEnable(GL2.GL_TEXTURE_2D);
            
            renderinfo.drawable = glad;
            testrenderer.render(renderinfo);
            
            gl.glUseProgram(0);
            gl.glDisable(GL2.GL_TEXTURE_2D);
            
            gl.glBegin(GL2.GL_LINES);
            gl.glColor4f(1f, 0f, 0f, 1f);
            gl.glVertex3f(0f, 0f, 0f);
            gl.glVertex3f(100000f, 0f, 0f);
            gl.glColor4f(0f, 1f, 0f, 1f);
            gl.glVertex3f(0f, 0f, 0f);
            gl.glVertex3f(0, 100000f, 0f);
            gl.glColor4f(0f, 0f, 1f, 1f);
            gl.glVertex3f(0f, 0f, 0f);
            gl.glVertex3f(0f, 0f, 100000f);
            gl.glEnd();
            
            glad.swapBuffers();
        }

        @Override
        public void reshape(GLAutoDrawable glad, int x, int y, int width, int height)
        {
            GL2 gl = glad.getGL().getGL2();
            
            //gl.setSwapInterval(1);
            gl.glViewport(x, y, width, height);
            
            float aspectRatio = (float)width / (float)height;
            gl.glMatrixMode(GL2.GL_PROJECTION);
            gl.glLoadIdentity();
            float ymax = 0.01f * (float)Math.tan(0.5f * (float)((70f * Math.PI) / 180f));
            gl.glFrustum(
                    -ymax * aspectRatio, ymax * aspectRatio,
                    -ymax, ymax,
                    0.01f, 1000f);
        }
        
        
        public void updateCamera()
        {
            Vector3 up;
            
            if (Math.cos(camRotation.y) < 0f)
            {
                upsideDown = true;
                up = new Vector3(0f, -1f, 0f);
            }
            else
            {
                upsideDown = false;
                up = new Vector3(0f, 1f, 0f);
            }
            
            camPosition.x = camDistance * (float)Math.cos(camRotation.x) * (float)Math.cos(camRotation.y);
            camPosition.y = camDistance * (float)Math.sin(camRotation.y);
            camPosition.z = camDistance * (float)Math.sin(camRotation.x) * (float)Math.cos(camRotation.y);
            
            camPosition = Vector3.add(camPosition, camTarget);
            
            modelViewMatrix = Matrix4.lookAt(camPosition, camTarget, up);
            
            modelViewMatrix = Matrix4.mult(Matrix4.scale(0.0001f), modelViewMatrix);
        }
        

        @Override
        public void mouseDragged(MouseEvent e)
        {
            if (lastMouseMove == null) return; // lame hack but how else can we avoid that
            
            float xdelta = e.getX() - lastMouseMove.x;
            float ydelta = e.getY() - lastMouseMove.y;
            
            lastMouseMove = e.getPoint();
            
            if (mouseButton == MouseEvent.BUTTON3)
            {
                if (upsideDown) xdelta = -xdelta;

                camRotation.x -= xdelta * 0.002f;
                camRotation.y -= ydelta * 0.002f;
            }
            else if (mouseButton == MouseEvent.BUTTON1)
            {
                xdelta *= 0.005f;
                ydelta *= 0.005f;

                camTarget.x -= xdelta * (float)Math.sin(camRotation.x);
                camTarget.x -= ydelta * (float)Math.cos(camRotation.x) * (float)Math.sin(camRotation.y);
                camTarget.y += ydelta * (float)Math.cos(camRotation.y);
                camTarget.z += xdelta * (float)Math.cos(camRotation.x);
                camTarget.z -= ydelta * (float)Math.sin(camRotation.x) * (float)Math.sin(camRotation.y);
            }

            updateCamera();
            e.getComponent().repaint();
        }

        @Override
        public void mouseMoved(MouseEvent e)
        {
            //
        }

        @Override
        public void mouseClicked(MouseEvent e)
        {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mousePressed(MouseEvent e)
        {
            if (mouseButton != MouseEvent.NOBUTTON) return;
            
            mouseButton = e.getButton();
            lastMouseMove = e.getPoint();
        }

        @Override
        public void mouseReleased(MouseEvent e)
        {
            if (e.getButton() != mouseButton) return;
            
            mouseButton = MouseEvent.NOBUTTON;
            lastMouseMove = e.getPoint();
        }

        @Override
        public void mouseEntered(MouseEvent e)
        {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseExited(MouseEvent e)
        {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseWheelMoved(MouseWheelEvent e)
        {
            float delta = (float)(e.getPreciseWheelRotation() * 0.1f);
            camTarget.x += delta * (float)Math.cos(camRotation.x) * (float)Math.cos(camRotation.y);
            camTarget.y += delta * (float)Math.sin(camRotation.y);
            camTarget.z += delta * (float)Math.sin(camRotation.x) * (float)Math.cos(camRotation.y);
            
            updateCamera();
            e.getComponent().repaint();
        }
        
        
        public GalaxyEditorForm parent;
        
        private Bmd testmodel;
        private BmdRenderer testrenderer;
        private GLRenderer.RenderInfo renderinfo;
        
        private Matrix4 modelViewMatrix;
        private float camDistance;
        private Vector2 camRotation;
        private Vector3 camPosition, camTarget;
        private Boolean upsideDown;
        
        private int mouseButton;
        private Point lastMouseMove;
    }
    
   
    public String galaxyName;
    public GalaxyArchive galaxyArc;
    private GalaxyRenderer renderer;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddObject;
    private javax.swing.JButton btnAddScenario;
    private javax.swing.JButton btnAddZone;
    private javax.swing.JButton btnDeleteObject;
    private javax.swing.JButton btnDeleteScenario;
    private javax.swing.JButton btnDeleteZone;
    private javax.swing.JButton btnEditScenario;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane3;
    private javax.swing.JSplitPane jSplitPane4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JToolBar jToolBar4;
    private javax.swing.JToolBar jToolBar5;
    private javax.swing.JList lbScenarioList;
    private javax.swing.JLabel lbStatusLabel;
    private javax.swing.JList lbZoneList;
    private javax.swing.JPanel pnlGLPanel;
    private javax.swing.JPanel pnlObjectSettings;
    private javax.swing.JTabbedPane tpLeftPanel;
    private javax.swing.JTree tvObjectList;
    // End of variables declaration//GEN-END:variables
}
