package iristk.app.kitchenMaid;

import java.util.List;
import java.io.File;
import iristk.xml.XmlMarshaller.XMLLocation;
import iristk.system.Event;
import iristk.flow.*;
import iristk.util.Record;
import static iristk.util.Converters.*;
import static iristk.flow.State.*;

public class RecipeFlow extends iristk.flow.Flow {

	private InstructionSet instructions;
	private AnimateMe animation;
	private Instruction instruction;
	private Measurement measure;

	private void initVariables() {
	}

	public Instruction getInstruction() {
		return this.instruction;
	}

	public void setInstruction(Instruction value) {
		this.instruction = value;
	}

	public Measurement getMeasure() {
		return this.measure;
	}

	public void setMeasure(Measurement value) {
		this.measure = value;
	}

	public InstructionSet getInstructions() {
		return this.instructions;
	}

	public AnimateMe getAnimation() {
		return this.animation;
	}

	@Override
	public Object getVariable(String name) {
		if (name.equals("instruction")) return this.instruction;
		if (name.equals("measure")) return this.measure;
		if (name.equals("instructions")) return this.instructions;
		if (name.equals("animation")) return this.animation;
		return null;
	}


	public RecipeFlow(InstructionSet instructions, AnimateMe animation) {
		this.instructions = instructions;
		this.animation = animation;
		initVariables();
	}

	@Override
	public State getInitialState() {return new goAhead();}


	public class goAhead extends State implements Initial {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 20
			try {
				EXECUTION: {
					int count = getCount(1212899836) + 1;
					incrCount(1212899836);
					iristk.flow.DialogFlow.listen state0 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state0, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 20, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 20, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 23
			try {
				count = getCount(1289696681) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(1289696681);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 24
						if (event.has("sem:wakeUp")) {
							// Line: 25
							Start state1 = new Start();
							flowThread.gotoState(state1, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 25, 26)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 26
						} else {
							// Line: 27
							goAhead state2 = new goAhead();
							flowThread.gotoState(state2, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 27, 28)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 23, 36));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Start extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 33
			try {
				EXECUTION: {
					int count = getCount(1940447180) + 1;
					incrCount(1940447180);
					// Line: 34
					animation.setVisible(true);
					iristk.flow.DialogFlow.say state3 = new iristk.flow.DialogFlow.say();
					StringCreator string4 = new StringCreator();
					string4.append("Hello. All right. Do you have everything you need?");
					state3.setText(string4.toString());
					if (!flowThread.callState(state3, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 33, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 37
					animation.setListen();
					iristk.flow.DialogFlow.listen state5 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state5, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 33, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 33, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 40
			try {
				count = getCount(1066376662) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes") && !event.has("sem:no")) {
						incrCount(1066376662);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 41
							animation.setTalk();
							iristk.flow.DialogFlow.say state6 = new iristk.flow.DialogFlow.say();
							StringCreator string7 = new StringCreator();
							string7.append("Cool. Lets get this party started");
							state6.setText(string7.toString());
							if (!flowThread.callState(state6, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 40, 77)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 43
							MoveOn state8 = new MoveOn();
							flowThread.gotoState(state8, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 43, 26)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 40, 77));
			}
			// Line: 45
			try {
				count = getCount(1490180672) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1490180672);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 46
							End state9 = new End();
							flowThread.gotoState(state9, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 46, 23)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 45, 57));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class MoveOn extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 51
			try {
				EXECUTION: {
					int count = getCount(1143839598) + 1;
					incrCount(1143839598);
					// Line: 52
					if (instructions.endOfRecipe()) {
						// Line: 53
						animation.setTalk();
						iristk.flow.DialogFlow.say state10 = new iristk.flow.DialogFlow.say();
						StringCreator string11 = new StringCreator();
						string11.append("You are finished with the recipe. Good job.");
						state10.setText(string11.toString());
						if (!flowThread.callState(state10, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 52, 42)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 55
						End state12 = new End();
						flowThread.gotoState(state12, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 55, 24)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 56
					} else {
						// Line: 57
						instruction = instructions.next();
						// Line: 58
						readInstruction state13 = new readInstruction();
						flowThread.gotoState(state13, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 58, 36)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 51, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class readInstruction extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 64
			try {
				EXECUTION: {
					int count = getCount(1100439041) + 1;
					incrCount(1100439041);
					// Line: 65
					animation.setTalk();
					iristk.flow.DialogFlow.say state14 = new iristk.flow.DialogFlow.say();
					state14.setText(instruction.getFullInstruction());
					if (!flowThread.callState(state14, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 64, 13)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 67
					if (instruction.getTimer()) {
						// Line: 68
						startTimer state15 = new startTimer();
						flowThread.gotoState(state15, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 68, 32)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 70
					Recipe state16 = new Recipe();
					flowThread.gotoState(state16, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 70, 26)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 64, 13));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Recipe extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 75
			try {
				EXECUTION: {
					int count = getCount(1023487453) + 1;
					incrCount(1023487453);
					// Line: 76
					animation.setListen();
					iristk.flow.DialogFlow.listen state17 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state17, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 75, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 75, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 80
			try {
				count = getCount(515132998) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes") && !event.has("sem:no") && !event.has("sem:ready")) {
						incrCount(515132998);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 81
							Wait state18 = new Wait();
							flowThread.gotoState(state18, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 81, 24)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 80, 99));
			}
			// Line: 83
			try {
				count = getCount(1365202186) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:repeat")) {
						incrCount(1365202186);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 84
							animation.setTalk();
							iristk.flow.DialogFlow.say state19 = new iristk.flow.DialogFlow.say();
							StringCreator string20 = new StringCreator();
							string20.append("Okey, let me repeat");
							state19.setText(string20.toString());
							if (!flowThread.callState(state19, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 83, 61)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 86
							readInstruction state21 = new readInstruction();
							flowThread.gotoState(state21, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 86, 35)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 83, 61));
			}
			// Line: 88
			try {
				count = getCount(474675244) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:question")) {
						incrCount(474675244);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 89
							if (event.get("sem:question") == "measurement") {
								// Line: 90
								Measurement state22 = new Measurement();
								flowThread.gotoState(state22, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 90, 32)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 91
							} else if (event.get("sem:question") == "ingredient") {
								// Line: 92
								Ingredient state23 = new Ingredient();
								flowThread.gotoState(state23, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 92, 31)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 93
							} else {
								iristk.flow.DialogFlow.say state24 = new iristk.flow.DialogFlow.say();
								StringCreator string25 = new StringCreator();
								string25.append("Oh no");
								state24.setText(string25.toString());
								if (!flowThread.callState(state24, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 89, 51)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 88, 63));
			}
			// Line: 97
			try {
				count = getCount(2111991224) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:ready") && !event.has("sem:no")) {
						incrCount(2111991224);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 98
							MoveOn state26 = new MoveOn();
							flowThread.gotoState(state26, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 98, 26)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 97, 79));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class startTimer extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 103
			try {
				EXECUTION: {
					int count = getCount(1993134103) + 1;
					incrCount(1993134103);
					iristk.flow.DialogFlow.prompt state27 = new iristk.flow.DialogFlow.prompt();
					StringCreator string28 = new StringCreator();
					string28.append("I will help you track the time. Let me know when to set the timer");
					state27.setText(string28.toString());
					if (!flowThread.callState(state27, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 103, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 103, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 106
			try {
				count = getCount(405662939) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:start")) {
						incrCount(405662939);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 107
							Timer state29 = new Timer();
							flowThread.gotoState(state29, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 107, 24)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 106, 60));
			}
			// Line: 109
			try {
				count = getCount(1130478920) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1130478920);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.flow.DialogFlow.say state30 = new iristk.flow.DialogFlow.say();
							StringCreator string31 = new StringCreator();
							string31.append("You need to set a timer for this part.");
							state30.setText(string31.toString());
							if (!flowThread.callState(state30, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 109, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 111
							startTimer state32 = new startTimer();
							flowThread.gotoState(state32, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 111, 30)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 109, 57));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Timer extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 116
			try {
				EXECUTION: {
					int count = getCount(123961122) + 1;
					incrCount(123961122);
					iristk.flow.DialogFlow.say state33 = new iristk.flow.DialogFlow.say();
					StringCreator string34 = new StringCreator();
					string34.append("Setting timer for");
					state33.setText(string34.toString());
					if (!flowThread.callState(state33, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 116, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state35 = new iristk.flow.DialogFlow.say();
					state35.setText(instruction.getAmount());
					if (!flowThread.callState(state35, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 116, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state36 = new iristk.flow.DialogFlow.say();
					state36.setText(instruction.getMeasurement());
					if (!flowThread.callState(state36, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 116, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 120
					animation.setTimer(instruction.getAmount());
					// Line: 121
					timerReady state37 = new timerReady();
					flowThread.gotoState(state37, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 121, 31)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 116, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class timerReady extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 126
			try {
				EXECUTION: {
					int count = getCount(942731712) + 1;
					incrCount(942731712);
					iristk.flow.DialogFlow.listen state38 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state38, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 126, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 128
					if (animation.timerReady()) {
						iristk.flow.DialogFlow.say state39 = new iristk.flow.DialogFlow.say();
						StringCreator string40 = new StringCreator();
						string40.append("Times up!!! Lets move on");
						state39.setText(string40.toString());
						if (!flowThread.callState(state39, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 128, 38)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 130
						MoveOn state41 = new MoveOn();
						flowThread.gotoState(state41, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 130, 27)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 131
					} else {
						// Line: 132
						timerReady state42 = new timerReady();
						flowThread.gotoState(state42, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 132, 31)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 126, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 135
			try {
				count = getCount(1940030785) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:timer")) {
						incrCount(1940030785);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.flow.DialogFlow.say state43 = new iristk.flow.DialogFlow.say();
							StringCreator string44 = new StringCreator();
							string44.append("It's");
							state43.setText(string44.toString());
							if (!flowThread.callState(state43, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 135, 60)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							iristk.flow.DialogFlow.say state45 = new iristk.flow.DialogFlow.say();
							state45.setText(animation.returnSeconds());
							if (!flowThread.callState(state45, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 135, 60)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							iristk.flow.DialogFlow.say state46 = new iristk.flow.DialogFlow.say();
							StringCreator string47 = new StringCreator();
							string47.append("seconds left");
							state46.setText(string47.toString());
							if (!flowThread.callState(state46, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 135, 60)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 135, 60));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Wait extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 143
			try {
				EXECUTION: {
					int count = getCount(1763847188) + 1;
					incrCount(1763847188);
					// Line: 144
					animation.setTalk();
					iristk.flow.DialogFlow.say state48 = new iristk.flow.DialogFlow.say();
					StringCreator string49 = new StringCreator();
					string49.append("Let me know when you are done with this step");
					state48.setText(string49.toString());
					if (!flowThread.callState(state48, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 143, 11)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 146
					animation.setListen();
					iristk.flow.DialogFlow.listen state50 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state50, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 143, 11)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 143, 11));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 149
			try {
				count = getCount(1192108080) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1192108080);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 150
							animation.setTalk();
							iristk.flow.DialogFlow.say state51 = new iristk.flow.DialogFlow.say();
							StringCreator string52 = new StringCreator();
							string52.append("Ok");
							state51.setText(string52.toString());
							if (!flowThread.callState(state51, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 149, 56)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 152
							Wait state53 = new Wait();
							flowThread.gotoState(state53, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 152, 23)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 149, 56));
			}
			// Line: 154
			try {
				count = getCount(537548559) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:ready") && !event.has("sem:no")) {
						incrCount(537548559);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 155
							animation.setTalk();
							// Line: 156
							boolean chosen54 = false;
							boolean matching55 = true;
							while (!chosen54 && matching55) {
								int rand56 = random(237852351, 3, iristk.util.RandomList.RandomModel.DECK_RESHUFFLE_NOREPEAT);
								matching55 = false;
								if (true) {
									matching55 = true;
									if (rand56 >= 0 && rand56 < 1) {
										chosen54 = true;
										iristk.flow.DialogFlow.say state57 = new iristk.flow.DialogFlow.say();
										StringCreator string58 = new StringCreator();
										string58.append("Good, lets move on");
										state57.setText(string58.toString());
										if (!flowThread.callState(state57, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 156, 11)))) {
											eventResult = EVENT_ABORTED;
											break EXECUTION;
										}
									}
								}
								if (true) {
									matching55 = true;
									if (rand56 >= 1 && rand56 < 2) {
										chosen54 = true;
										iristk.flow.DialogFlow.say state59 = new iristk.flow.DialogFlow.say();
										StringCreator string60 = new StringCreator();
										string60.append("Awesome, time for the next step");
										state59.setText(string60.toString());
										if (!flowThread.callState(state59, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 156, 11)))) {
											eventResult = EVENT_ABORTED;
											break EXECUTION;
										}
									}
								}
								if (true) {
									matching55 = true;
									if (rand56 >= 2 && rand56 < 3) {
										chosen54 = true;
										iristk.flow.DialogFlow.say state61 = new iristk.flow.DialogFlow.say();
										StringCreator string62 = new StringCreator();
										string62.append("Whoop whoop moving on");
										state61.setText(string62.toString());
										if (!flowThread.callState(state61, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 156, 11)))) {
											eventResult = EVENT_ABORTED;
											break EXECUTION;
										}
									}
								}
							}
							// Line: 161
							MoveOn state63 = new MoveOn();
							flowThread.gotoState(state63, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 161, 25)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 154, 78));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Dialog extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 166
			try {
				count = getCount(1608446010) + 1;
				if (event.triggers("sense.user.silence")) {
					incrCount(1608446010);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 167
						animation.setTalk();
						iristk.flow.DialogFlow.say state64 = new iristk.flow.DialogFlow.say();
						StringCreator string65 = new StringCreator();
						string65.append("How is it going");
						state64.setText(string65.toString());
						if (!flowThread.callState(state64, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 166, 38)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 169
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 169, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 166, 38));
			}
			// Line: 171
			try {
				count = getCount(1297685781) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(1297685781);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 172
						if (event.has("sem:soGood")) {
							iristk.flow.DialogFlow.say state66 = new iristk.flow.DialogFlow.say();
							StringCreator string67 = new StringCreator();
							string67.append("I'm glad you like it. The recipe is from my mom.");
							state66.setText(string67.toString());
							if (!flowThread.callState(state66, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 172, 33)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 174
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 174, 15)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 175
						} else {
							// Line: 176
							animation.setTalk();
							iristk.flow.DialogFlow.say state68 = new iristk.flow.DialogFlow.say();
							StringCreator string69 = new StringCreator();
							string69.append("I am sorry, I didn't get that.");
							state68.setText(string69.toString());
							if (!flowThread.callState(state68, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 172, 33)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 178
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 178, 15)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 171, 36));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Measurement extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 184
			try {
				EXECUTION: {
					int count = getCount(1785210046) + 1;
					incrCount(1785210046);
					// Line: 185
					animation.setTalk();
					iristk.flow.DialogFlow.say state70 = new iristk.flow.DialogFlow.say();
					StringCreator string71 = new StringCreator();
					string71.append("Let me repeat the amount");
					state70.setText(string71.toString());
					if (!flowThread.callState(state70, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 184, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state72 = new iristk.flow.DialogFlow.say();
					state72.setText(instruction.getMeasurement());
					if (!flowThread.callState(state72, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 184, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 188
					Recipe state73 = new Recipe();
					flowThread.gotoState(state73, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 188, 26)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 184, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Ingredient extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 193
			try {
				EXECUTION: {
					int count = getCount(914504136) + 1;
					incrCount(914504136);
					// Line: 194
					animation.setTalk();
					iristk.flow.DialogFlow.say state74 = new iristk.flow.DialogFlow.say();
					StringCreator string75 = new StringCreator();
					string75.append("Let me repeat the ingredient");
					state74.setText(string75.toString());
					if (!flowThread.callState(state74, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 193, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state76 = new iristk.flow.DialogFlow.say();
					state76.setText(instruction.getIngredient());
					if (!flowThread.callState(state76, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 193, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 197
					Recipe state77 = new Recipe();
					flowThread.gotoState(state77, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 197, 26)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 193, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class End extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 202
			try {
				EXECUTION: {
					int count = getCount(824009085) + 1;
					incrCount(824009085);
					// Line: 203
					animation.setTalk();
					iristk.flow.DialogFlow.say state78 = new iristk.flow.DialogFlow.say();
					StringCreator string79 = new StringCreator();
					string79.append("Okay, goodbye");
					state78.setText(string79.toString());
					if (!flowThread.callState(state78, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 202, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 205
					System.exit(0);
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 202, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


}
